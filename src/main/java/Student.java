public class Student {

  private String Name;
  private int Age;
  private String Nazwisko;
  private String BirthDate;

  public Student(String name, String nazwisko, int age, String birthDate) {
    Name = name;
    Age = age;
    Nazwisko = nazwisko;
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
      return new Student("Parse", "--", -1, "0000-00-00");

    String name = data[0];
    String nazwisko = data[1];
    int wiek;
    try {
      wiek = Integer.parseInt(data[2]);
    } catch (NumberFormatException e) {
      return new Student("Parse", "--", -1, "0000-00-00");
    }

    String birthDate = data[3];
    return new Student(name, nazwisko, wiek, birthDate);
  }
}