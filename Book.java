package Library;

import java.sql.Timestamp;

public class Book {
    private int Count;
    private String Author;
    private int Price;
    private int code;
    private String sub;
    private Timestamp date;
    private int Item;

    public Book(int Price, int code, String sub, Timestamp date) {
        this.Price = Price;
        this.code = code;
        this.sub = sub;
        this.date = date;
    }

    public Book(String Author, int Price, int code, String sub, int Count) {
        this.Author = Author;
        this.Price = Price;
        this.code = code;
        this.sub = sub;
        this.Count = Count;
    }

    public Book(String Author, int Price, int code, String sub) {
        this.Author = Author;
        this.Price = Price;
        this.code = code;
        this.sub = sub;
    }

    public Book(String Author, int Price, int code, int Item, int Count) {
        this.Author = Author;
        this.Price = Price;
        this.code = code;
        this.Item = Item;
        this.Count = Count;
    }

    public Book(int code, int Count) {
        this.Count = Count;
        this.code = code;
    }

    public Book(int Item) {
        this.Item = Item;
    }

    public Book() {

    }

    /**
     * @return int return the Page
     */
    public Timestamp getdate() {
        return date;
    }

    /**
     * @param Page the Page to set
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * @return int return the Page
     */
    public String getsub() {
        return sub;
    }

    /**
     * @param Page the Page to set
     */
    public void setsub(String sub) {
        this.sub = sub;
    }

    /**
     * @return int return the Page
     */
    public int getcode() {
        return code;
    }

    /**
     * @param Page the Page to set
     */
    public void setcode(int code) {
        this.code = code;
    }

    /**
     * @return int return the Page
     */
    public int getCount() {
        return Count;
    }

    /**
     * @param Page the Page to set
     */
    public void setPage(int Count) {
        this.Count = Count;
    }

    /**
     * @return String return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }

    /**
     * @return int return the Price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(int Price) {
        this.Price = Price;
    }

    /**
     * @param Count the Count to set
     */
    public void setCount(int Count) {
        this.Count = Count;
    }

    /**
     * @return int return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return String return the sub
     */
    public String getSub() {
        return sub;
    }

    /**
     * @param sub the sub to set
     */
    public void setSub(String sub) {
        this.sub = sub;
    }

    /**
     * @return Timestamp return the date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * @return int return the Item
     */
    public int getItem() {
        return Item;
    }

    /**
     * @param Item the Item to set
     */
    public void setItem(int Item) {
        this.Item = Item;
    }

}
