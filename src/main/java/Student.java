public class Student {

  private String Name;
  private int Age;
  private String Nazwisko;

  public Student(String name, String nazwisko, int age) {
    Name = name;
    Age = age;
    Nazwisko = nazwisko;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetNazwisko() {return Nazwisko;}
  
  public String ToString() {
    return Name + " " + Nazwisko + " " + Integer.toString(Age);
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3) 
      return new Student("Parse", "--", -1);
    String Name = data[0];
    String Nazwisko = data[1];
    int wiek;
    try {
      wiek = Integer.parseInt(data[2]);
      } catch (NumberFormatException e) {
      return new Student("Parse", "--", -1);
      }
    return new Student(data[0], data[1], Integer.parseInt(data[2]));
  }
}