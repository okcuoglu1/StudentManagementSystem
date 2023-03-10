import java.util.List;
import java.util.Scanner;

//3-student ile ilgili metodlar
public class StudentService {

    Scanner inp=new Scanner(System.in);

    //reponun metodlarını kullanmak için
    StudentRepository repository=new StudentRepository();

    //9-tablo oluşturmak için metod
    public void createTable(){
        repository.createTable();
    }

    //11-öğrenci kaydetme
    public void saveStudent(){
        System.out.println("Ad: ");
        String name=inp.nextLine().trim();
        System.out.println("Soyad: ");
        String lastname=inp.nextLine().trim();
        System.out.println("Sehir: ");
        String city=inp.nextLine().trim();
        System.out.println("Yas: ");
        int age= inp.nextInt();
        inp.nextLine();
        Student newStudent=new Student(name,lastname,city,age);
        repository.save(newStudent);
    }

    //13-tüm öğrencileri listeleme
    public void getAllStudents(){
        repository.findAll();
    }

    //15-Öğrenciyi silme
    public void deleteStudent(int id){
        //bu id ile öğrenci var mı??-->best practice
        repository.delete(id);
    }
    //17-id ile öğrenciyi getirme
    public Student getStudentById(int id){
        Student student=repository.findStudentById(id);
        return student;
    }
    //19-öğrenciyi güncelleme
    public void updateStudent(int id){
        //bu id ile öğrenci var mı???
        Student student=getStudentById(id);
        if(student==null){
            System.out.println("öğrenci bulunamadı!!!");
        }else {
            System.out.println("Ad: ");
            String name=inp.nextLine().trim();
            System.out.println("Soyad: ");
            String lastname=inp.nextLine().trim();
            System.out.println("Sehir: ");
            String city=inp.nextLine().trim();
            System.out.println("Yas: ");
            int age= inp.nextInt();
            inp.nextLine();
            //yeni değerler ile fieldarı güncelle
            student.setName(name);
            student.setLastname(lastname);
            student.setCity(city);
            student.setAge(age);
            repository.update(student);
        }
    }
    //21-girilen ad veya soyad bilgisini içeren kayıtları listeleme
    //kelime=act---> ad: soyad:React....
    public void listStudentsByNameOrLastname(){
        System.out.println("Ad veya soyad: ");
        String nameOrLastname=inp.nextLine();
        //birden fazla kayıt dönebilir
        List<Student> studentList=repository.findStudentByNameOrLastname(nameOrLastname);
        //listedeki öğrencileri yazdıralım
        //liste boşsa?
        if(studentList.size()==0){
            System.out.println("Öğrenci bulunamadı.");
        }else {
            studentList.forEach(System.out::println);
        }
    }
}