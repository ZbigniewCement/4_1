public class Student {
  private String Name;
  private int Age;
  private String Nazwisko;
  private String BirthDate;

  public Student(String name, String nazwisko, int age, String birthDate) {
    Name = name;
    Nazwisko = nazwisko;
    Age = age;
    BirthDate = birthDate;
  }

  public String GetName() { return Name; }
  public int GetAge() { return Age; }
  public String GetNazwisko() { return Nazwisko; }
  public String GetBirthDate() { return BirthDate; }

  public String ToString() {
    return Name + " " + Nazwisko + " " + Age + " " + BirthDate;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4) 
      return new Student("Parse", "--", -1, "--");

    String Name = data[0];
    String Nazwisko = data[1];
    int wiek;
    try {
      wiek = Integer.parseInt(data[2]);
    } catch (NumberFormatException e) {
      return new Student("Parse", "--", -1, "--");
    }
    String BirthDate = data[3];
    return new Student(Name, Nazwisko, wiek, BirthDate);
  }
}