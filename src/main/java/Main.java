/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      boolean dziala = true;

      while (dziala) {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl studentów");
        System.out.println("3. Zakończ ");
        System.out.println(" ");
        
        int menu = scanner.nextInt(); // Wybór opcji

        switch (menu) {
          case 1:
            System.out.print("Podaj imię studenta: ");
            String name = scanner.next();
            System.out.print("Podaj nazwisko studenta: ");
            String nazwisko = scanner.next();
            System.out.print("Podaj wiek studenta: ");
            int age = scanner.nextInt();
            s.addStudent(new Student(name, nazwisko, age));
            break;
          case 2:
            var students = s.getStudents();
            for (Student current : students) {
              System.out.println(current.ToString());
              System.out.println(" ");
            }
            break;
          case 3:
            dziala = false; 
            break;
          default:
            System.out.println("Nieznana opcja, spróbuj ponownie.");
            break;
        }
      }

      scanner.close();
    } catch (IOException e) {
    }
  }
}