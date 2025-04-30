import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Service {
  
  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

 
  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line;
    while ((line = reader.readLine()) != null) {
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }


  public Student findStudentByName(String name) throws IOException {
    var students = getStudents();  
    for (Student student : students) {
      if (student.GetName().equalsIgnoreCase(name)) {  
        return student;
      }
    }
    return null;  
  }


  public boolean deleteStudent(String name, String surname) throws IOException {
    var students = getStudents(); 
    var updatedStudents = new ArrayList<Student>();

    boolean studentFound = false;

 
    for (Student student : students) {
      if (student.GetName().equalsIgnoreCase(name) && student.GetNazwisko().equalsIgnoreCase(surname)) {
        studentFound = true; 
      } else {
        updatedStudents.add(student); 
      }
    }

    
    if (studentFound) {
      var f = new FileWriter("db.txt");
      var b = new BufferedWriter(f);
      for (Student student : updatedStudents) {
        b.append(student.ToString());
        b.newLine();
      }
      b.close();
      return true; 
    }

    return false; 
  }
}