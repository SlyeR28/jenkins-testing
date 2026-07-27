import java.time.LocalDateTime;

public class testing {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("My Name is Rishabh Kumar");
        System.out.println(LocalDateTime.now().toString());
        System.out.println("Jenkins CI/CD");
        System.out.println("Let go baby");

        Student st = new Student(1L , "Rishabh Kumar" , 32 , "Guru Tegh Bahadur Public School");
        System.out.println(st.toString());
    }
}
