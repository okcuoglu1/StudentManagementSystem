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
        String name=inp.nextLine();
        System.out.println("Soyad: ");
        String lastname=inp.nextLine();
        System.out.println("Sehir: ");
        String city=inp.nextLine();
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
        repository.delete(id);
    }

}
