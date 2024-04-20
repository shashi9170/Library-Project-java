package Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Data {
    Connection connection = Connection_database.Provide_Connection();

    /*
     * Registered the student
     */

    public int Register(Student u) {
        try {
            String sql = "insert into student (Roll, Name, Email, Branch, Phone, Age) values(?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getRoll_no());
            st.setString(2, u.getName());
            st.setString(3, u.getEmail());
            st.setString(4, u.getBranch());
            st.setLong(5, u.getPhone_no());
            st.setInt(6, u.getAge());

            return st.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    /*
     * Show the total book store in the Storage
     */

    public ArrayList<Book> Total_Book() {
        ArrayList<Book> data = new ArrayList<>();
        try {
            String sql = "select * from Book b join Author a on a.item = b.item";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String Author = rs.getString("Author_name");
                int Price = rs.getInt("Price");
                int Code = rs.getInt("Code");
                String Subject = rs.getString("Subject");
                int count = rs.getInt("Count");
                Book s = new Book(Author, Price, Code, Subject, count);
                data.add(s);
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    /*
     * Book issue
     */

    public Book Issue_book(Issue s) {

        boolean f = this.Registered_student(s.getRoll());
        if (!f) {
            System.out.println("You have not registered \nPlease register your profile in library Enter the key : 1");
            return null;
        }
        int re = this.Available(s);
        int data = this.Number_item(s.getRoll(), s.getCode());

        if (re >= 1 && data == 0) {
            Book b = this.Student_issue(s);
            int issu = this.Issuee(b, s);
            int update = this.Update_Book(b, re - 1);
            return b;
        }
        Book d = new Book(-1);
        return d;
    }

    /*
     * check Only one type book issue
     */

    public int Number_item(int Roll, int Code) {
        try {
            String sql = "select * from issue where Code = (?) and Roll = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Code);
            st.setInt(2, Roll);
            ResultSet rs = st.executeQuery();

            int cnt = 0;
            while (rs.next())
                cnt++;

            return cnt;
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     * Store the book of the student
     */

    public int Issuee(Book b, Issue s) {
        try {
            String sql = "insert into Issue (Roll, Code, Price, Subject) values(?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, s.getRoll());
            st.setInt(2, b.getcode());
            st.setInt(3, b.getPrice());
            st.setString(4, s.getSubject());

            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*
     * Update the book storage at the time issue
     */

    public int Update_Book(Book s, int re) {
        try {
            String sql = "update Author a join Book b on a.item = b.item set a.Count = (?) where a.Code = (?) and b.Subject = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, re);
            st.setInt(2, s.getcode());
            st.setString(3, s.getsub());

            return st.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     * Issue the book of the student
     */

    public Book Student_issue(Issue s) {
        try {
            String sql = "select * from Book b join Author a on a.item = b.item where subject = (?) and Code = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSubject());
            st.setInt(2, s.getCode());

            ResultSet rs = st.executeQuery();
            Book b = null;
            while (rs.next()) {
                String Author = rs.getString("Author_name");
                int Price = rs.getInt("Price");
                int Code = rs.getInt("Code");
                String Subject = rs.getString("Subject");
                int count = rs.getInt("Count");
                b = new Book(Author, Price, Code, Subject, count);
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * How many book Available Any one Subject
     */

    public int Available(Issue s) {
        try {
            String sql = "select * from Book b join Author a on a.item = b.item where b.Subject = (?) and a.Code = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSubject());
            st.setInt(2, s.getCode());
            ResultSet rs = st.executeQuery();

            int cnt = 0;
            while (rs.next())
                cnt = rs.getInt("Count");

            return cnt;
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     * Update the book issue from student storage
     */

    public boolean Return_book(Issue s) {
        boolean b = Same_book(s);
        if (b == false) {
            return false;
        }

        try {
            if (this.Update_Return(s) == 1) {
                String sql = "delete from Issue where Roll = (?) and Subject = (?) and Code = (?)";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, s.getRoll());
                st.setString(2, s.getSubject());
                st.setInt(3, s.getCode());

                boolean d = st.execute();
                return d == false ? true : false;

            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * Store the return book
     */

    public int Update_Return(Issue s) {
        int re = this.Available(s) + 1;
        try {
            String sql = "update Author a join Book b on a.item = b.item set a.Count = (?) where a.Code = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, re);
            st.setInt(2, s.getCode());

            return st.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     * Check return book Same or not
     */

    public boolean Same_book(Issue s) {
        try {
            String sql = "select * from Issue where Roll = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s.getRoll());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int Roll = rs.getInt("Roll");
                int Code = rs.getInt("Code");
                String Subject = rs.getString("Subject");

                if (Roll == s.getRoll() && Code == s.getCode() && Subject.equals(s.getSubject()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * Admin Enter the book
     */

    public boolean Add_book(Book b) {
        int count = this.Number_of_book(b.getcode());
        boolean present = this.Present_book(b);

        if (present) {
            int update = this.Update_Add(b, count);
            return true;
        } else {
            boolean new_book = this.Insert_new(b);
            return new_book;
        }
    }

    /*
     * New book add Admin
     */

    public boolean Insert_new(Book u) {
        try {
            String sql = "insert into Author(Item, Author_name, Code, Price, Count) values (?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, u.getItem());
            st.setString(2, u.getAuthor());
            st.setInt(3, u.getCode());
            st.setInt(4, u.getPrice());
            st.setInt(5, u.getCount());

            boolean d = st.execute();
            return d == false ? true : false;
        } catch (SQLException e) {
            return false;
        }
    }

    /*
     * Check book Available or not
     */

    public boolean Present_book(Book b) {
        try {
            String sql = "select * from Author where Code = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, b.getcode());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int Code = rs.getInt("Code");
                return Code == b.getcode();
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    /*
     * Update the book at the return time
     */

    public int Update_Add(Book b, int count) {
        try {
            String sql = "update Author a join Book b on a.item = b.item set a.Count = (?) where a.Code = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, b.getCount() + count);
            st.setInt(2, b.getcode());

            return st.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     * See the book from the Code
     */

    public int Number_of_book(int Code) {
        try {
            String sql = "select * from Author a join Book b on a.item = b.item where a.Code = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Code);
            ResultSet rs = st.executeQuery();

            while (rs.next())
                return rs.getInt("Count");
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    /*
     * One student issue book check with our Roll number
     */

    public ArrayList<Book> Total_issue_book(int Roll) {
        ArrayList<Book> data = new ArrayList<>();
        try {
            String sql = "select * from issue where Roll = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Roll);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int Price = rs.getInt("Price");
                int Code = rs.getInt("Code");
                String Subject = rs.getString("Subject");
                Timestamp date = rs.getTimestamp("Date_i");
                Book s = new Book(Price, Code, Subject, date);
                data.add(s);
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    /*
     * Student registered or not
     */

    public boolean Registered_student(int roll) {
        try {
            String sql = "select * from student where Roll = (?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, roll);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int Roll = rs.getInt("Roll");
                return (Roll == roll);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * Registered Student
     */

    public ArrayList<Student> All_Student() {
        ArrayList<Student> data = new ArrayList<>();

        try {
            String sql = "select * from student";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int Roll = rs.getInt("Roll");
                String Name = rs.getString("Name");
                String Email = rs.getString("Email");
                String Branch = rs.getString("Branch");
                long phone = rs.getLong("Phone");
                int Age = rs.getInt("Age");

                Student s = new Student(Name, Roll, Email, Branch, phone, Age);
                data.add(s);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
