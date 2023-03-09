import java.util.Scanner;

/*
Proje:Student Management System
     -1-Herhangi bir eğitim kurumu için öğrenci yönetim uygulaması geliştiriniz.
     -2-Kullanıcı
               -öğrenci kayıt
               -öğrenci veya öğrencileri görüntüleme
               -id ile öğrenci güncelleme
               -id ile öğrenci silme
       işlemlerini yapabilmeli.
     -3-öğrenci:id,name,lastname,city,age özelliklerine sahiptir.
 */
public class Runner {
    public static void main(String[] args) {
        start();
    }

    //1-uygulama için menu oluştur
    //2-student class ını oluştur
    public static void start(){
        Scanner inp=new Scanner(System.in);
        StudentService service=new StudentService();
        //10-uygulama çalıştırıldığında tablo oluşturulsun
        service.createTable();

        int select;
        do {
            System.out.println("=================================");
            System.out.println("Öğrenci Yönetim Paneli");
            System.out.println("1-Öğrenci Kayıt");
            System.out.println("2-Tüm öğrencileri listele");
            System.out.println("3-Öğrenci Güncelle");
            System.out.println("4-Öğrenci Sil");
            System.out.println("5-Öğrenci Bul");
            System.out.println("0-ÇIKIŞ");
            System.out.println("İşlem seçiniz: ");
            select= inp.nextInt();
            inp.nextLine();
            int id;
            switch (select){
                case 1:
                    service.saveStudent();
                    break;
                case 2:
                    service.getAllStudents();
                    break;
                case 3:
                    id=getId(inp);
                    //güncelleme
                    break;
                case 4:
                    id=getId(inp);
                    service.deleteStudent(id);
                    break;
                case 5:
                    id=getId(inp);
                    //öğr bulma
                    break;
                case 0:
                    System.out.println("İyi günler...");
                    break;
                default:
                    System.out.println("Hatalı giriş!!!");
                    break;
            }

        }while (select!=0);

    }
    private static int getId(Scanner inp){
        System.out.println("Öğrenci id: ");
        int id=inp.nextInt();
        inp.nextLine();
        return id;
    }
}
