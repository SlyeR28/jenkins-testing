public class Student {

    private Long id;
    private Integer roll_no;
    private String name;
    private String school;

    public Student(Long id, String name, Integer roll_no, String school) {
        this.id = id;
        this.name = name;
        this.roll_no = roll_no;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(Integer roll_no) {
        this.roll_no = roll_no;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    // added method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", roll_no=" + roll_no +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
