package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Data d = new Data();

        while (true) {
            System.out.println("\nEnter 1 Register");
            System.out.println("Enter 2 Issue book");
            System.out.println("Enter 3 Return book");
            System.out.println("Enter 4 Show all book");
            System.out.println("Enter 5 Show All student");
            System.out.println("Enter 6 Show Your issue book");
            System.out.println("Enter 7 Add book");
            System.out.println("Enter 8 Add new book");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: {

                    System.out.println("\nEnter the name");
                    String Name = sc.nextLine();

                    System.out.println("Enter the roll number");
                    int Roll = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the email");
                    String Email = sc.nextLine();

                    System.out.println("Enter the branch");
                    String Branch = sc.nextLine();

                    System.out.println("Enter phone number");
                    long Phone = sc.nextLong();
                    sc.nextLine();

                    System.out.println("Enter the age");
                    int Age = sc.nextInt();
                    sc.nextLine();

                    Student st = new Student(Name, Roll, Email, Branch, Phone, Age);
                    int b = d.Register(st);

                    if (b == 1)
                        System.out.println("You have registered successfully");
                    else
                        System.out.println("You have not registered");
                    break;
                }

                case 2: {
                    System.out.println("\nEnter the roll number");
                    int Roll = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter code of book");
                    int code = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the subject");
                    String subject = sc.nextLine();

                    Issue i = new Issue(Roll, code, subject);
                    Book b = d.Issue_book(i);

                    if (b == null) {
                        break;
                    }

                    if (b.getItem() == -1) {
                        System.out.println("This book already issue to you");
                        break;
                    }
                    System.out.println(b.getAuthor() + " | " + b.getPrice() + " | " + b.getsub()
                            + " | " + b.getcode());
                    break;
                }

                case 3: {
                    System.out.println("\nEnter the roll number");
                    int Roll = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter code of book");
                    int code = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the subject");
                    String subject = sc.nextLine();

                    Issue i = new Issue(Roll, code, subject);
                    boolean b = d.Return_book(i);

                    if (b)
                        System.out.println("Your book return successfully");
                    else
                        System.out.println("This book is not issue to you");
                    break;
                }

                case 4: {
                    ArrayList<Book> book = d.Total_Book();

                    if (book == null) {
                        System.out.println("No book present time");
                        break;
                    }

                    System.out.println("Subject | Author | Price | Code | No_Book");

                    for (Book p : book) {
                        System.out
                                .println(p.getsub() + " | " + p.getAuthor() + " | " + p.getPrice() + " | " +
                                        p.getcode()
                                        + " | " + p.getCount());
                    }
                    break;
                }

                case 5: {
                    ArrayList<Student> st = d.All_Student();

                    if (st == null) {
                        System.out.println("No student register");
                        break;
                    }

                    System.out.println("Name | Roll | Branch | Email | Phone | Age");

                    for (Student s : st) {
                        System.out.println(s.getName() + " | " + s.getRoll_no() + " | " +
                                s.getBranch() + " | "
                                + s.getEmail() + " | " + s.getPhone_no() + " | " + s.getAge());
                    }
                    break;
                }

                case 6: {
                    System.out.println("\nEnter your Roll number");
                    int Roll = sc.nextInt();
                    sc.nextLine();

                    ArrayList<Book> book = d.Total_issue_book(Roll);

                    if (book == null || book.size() == 0) {
                        System.out.println("No book issue");
                        break;
                    }

                    System.out.println("Subject | Date & Time | Price | Code");

                    for (Book b : book) {
                        System.out
                                .println(b.getsub() + " | " + b.getdate() + " | " + b.getPrice() + " | " +
                                        b.getcode());
                    }
                    break;
                }

                case 7: {
                    System.out.println("\nEnter the Code");
                    int Code = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the number of book");
                    int cnt = sc.nextInt();
                    sc.nextLine();

                    Book b = new Book(Code, cnt);

                    boolean add = d.Add_book(b);

                    if (add)
                        System.out.println("Book Add successfully");
                    else
                        System.out.println("Book not added");

                    break;
                }

                case 8: {
                    System.out.println("Enter subject Number");
                    int Item = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Author name");
                    String author = sc.nextLine();

                    System.out.println("Enter the price");
                    int price = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the Code");
                    int Code = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the number of book");
                    int cnt = sc.nextInt();
                    sc.nextLine();

                    Book b = new Book(author, price, Code, Item, cnt);

                    boolean add = d.Add_book(b);

                    if (add)
                        System.out.println("New Book Add successfully");
                    else
                        System.out.println("New Book not added");

                    break;
                }
                default: {
                    System.out.println("Please Enter correct key\n");
                    break;
                }
            }
        }
    }
}
