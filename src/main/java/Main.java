/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      boolean dziala = true;

      while (dziala) {
      
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl studentów");
        System.out.println("3. Znajdź studenta po imieniu");
        System.out.println("4. Usuń studenta");
        System.out.println("5. Zakończ");
        System.out.println(" ");

        int menu = scanner.nextInt();
        scanner.nextLine(); 

        switch (menu) {
          case 1:
            
            System.out.print("Podaj imię studenta: ");
            String name = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta: ");
            String nazwisko = scanner.nextLine();

            int age;
            while (true) {
              System.out.print("Podaj wiek studenta: ");
              age = scanner.nextInt();
              if (age > 0) break;
              System.out.println("Wiek musi być liczbą dodatnią.");
            }

            int year, month, day;
            while (true) {
              System.out.print("Podaj rok urodzenia: ");
              year = scanner.nextInt();
              System.out.print("Podaj miesiąc urodzenia: ");
              month = scanner.nextInt();
              System.out.print("Podaj dzień urodzenia: ");
              day = scanner.nextInt();
              if (year > 0 && month > 0 && day > 0 && day <= 31) break;
              System.out.println("Nieprawidłowa data. Spróbuj ponownie.");
            }

            scanner.nextLine();
            String birthDate = String.format("%04d-%02d-%02d", year, month, day);
            s.addStudent(new Student(name, nazwisko, age, birthDate));
            break;

          case 2:
           
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("Brak studentów w systemie.");
            } else {
              for (Student current : students) {
                System.out.println(current.ToString());
                System.out.println(" ");
              }
            }
            break;

          case 3:
            
            System.out.print("Podaj imię studenta do wyszukania: ");
            String searchName = scanner.nextLine();
            Student foundStudent = s.findStudentByName(searchName);
            if (foundStudent != null) {
              System.out.println("Znaleziony student: ");
              System.out.println(foundStudent.ToString());
            } else {
              System.out.println("Nie znaleziono studenta o podanym imieniu.");
            }
            break;

          case 4:
            
            System.out.print("Podaj imię studenta do usunięcia: ");
            String deleteName = scanner.nextLine();
            System.out.print("Podaj nazwisko studenta do usunięcia: ");
            String deleteSurname = scanner.nextLine();

            boolean deleteSuccess = s.deleteStudent(deleteName, deleteSurname);
            if (deleteSuccess) {
              System.out.println("Student został usunięty.");
            } else {
              System.out.println("Nie znaleziono studenta o podanym imieniu i nazwisku.");
            }
            break;

          case 5:
            dziala = false; 
            break;

          default:
            System.out.println("Nieznana opcja, spróbuj ponownie.");
            break;
        }
      }

      scanner.close(); 
    } catch (IOException e) {
      System.out.println("Wystąpił błąd wejścia/wyjścia: " + e.getMessage());
    }
  }
}