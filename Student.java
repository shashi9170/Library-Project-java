package Library;

public class Student {
    private String Name;
    private int Roll_no;
    private String Branch;
    private String Email;
    private long Phone_no;
    private int Age;

    public Student(String Name, int Roll_no, String Email, String Branch, long Phone_no, int Age) {
        this.Name = Name;
        this.Roll_no = Roll_no;
        this.Email = Email;
        this.Branch = Branch;
        this.Phone_no = Phone_no;
        this.Age = Age;
    }

    public Student(String Name, String Branch, int Roll_no, String Email) {
        this.Name = Name;
        this.Branch = Branch;
        this.Email = Email;
        this.Roll_no = Roll_no;
    }

    public Student(String Branch, int Roll_no) {
        this.Branch = Branch;
        this.Roll_no = Roll_no;
    }

    public Student() {

    }

    /**
     * @return String return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * @return int return the Roll_no
     */
    public int getRoll_no() {
        return Roll_no;
    }

    /**
     * @param Roll_no the Roll_no to set
     */
    public void setRoll_no(int Roll_no) {
        this.Roll_no = Roll_no;
    }

    /**
     * @return String return the Branch
     */
    public String getBranch() {
        return Branch;
    }

    /**
     * @param Branch the Branch to set
     */
    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

    /**
     * @return String return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return long return the Phone_no
     */
    public long getPhone_no() {
        return Phone_no;
    }

    /**
     * @param Phone_no the Phone_no to set
     */
    public void setPhone_no(long Phone_no) {
        this.Phone_no = Phone_no;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return Age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.Age = age;
    }

}
