package Library;

public class Issue {
    private int Roll;
    private String Branch;
    private int Code;
    private String Subject;

    public Issue(int Roll, int Code, String Subject) {
        this.Subject = Subject;
        this.Code = Code;
        this.Roll = Roll;
    }

    public Issue() {

    }

    /**
     * @return int return the Roll
     */
    public int getRoll() {
        return Roll;
    }

    /**
     * @param Roll the Roll to set
     */
    public void setRoll(int Roll) {
        this.Roll = Roll;
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
     * @return int return the Code
     */
    public int getCode() {
        return Code;
    }

    /**
     * @param Code the Code to set
     */
    public void setCode(int Code) {
        this.Code = Code;
    }

    /**
     * @return String return the Subject
     */
    public String getSubject() {
        return Subject;
    }

    /**
     * @param Subject the Subject to set
     */
    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

}
