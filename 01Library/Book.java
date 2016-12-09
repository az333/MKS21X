public class Book {
    private String title, author, ISBN;

    public Book () {
	title = "";
	author = "";
	ISBN = ""; 
    }

    public Book (String title, String author, String ISBN) {
	this.title = title;
	this.author = author;
	this.ISBN = ISBN;

    }

    public String getTitle () {return title;}

    public String getAuthor () {return author;}

    public String getISBN () {return ISBN;}

    public void setTitle (String title) {this.title = title;}

    public void setAuthor (String author) {this.author = author;}
    
    public void setISBN (String ISBN) {this.ISBN = ISBN;}

    public String toString () {
	return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\n";
    }

    public static void main (String[] args) {
	Book b = new Book ("A", "B" , "4");
	System.out.println (b);
    }
}
