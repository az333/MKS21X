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


abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callnum;

    public LibraryBook (String title, String author, String ISBN, String callnum){
	super (title, author, ISBN);
	this.callnum = callnum;
    }

    public String getCallNumber () { return callnum; }

    public void setCallNumber (String callnum) { this.callnum = callnum; }

    abstract void checkout (String patron, String due);

    abstract void returned ();

    abstract String circulationStatus ();

    public int compareTo (LibraryBook b) {
	if (callnum.compareTo( b.callnum) > 0) return 1;
	else if (callnum.equals (b.callnum)) return 0;
	else return -1;
    }

    public String toString () {
	return super.toString() + "Call Number: " + callnum + "\n" ;
    }
	
}


class ReferenceBook extends LibraryBook {
    private String collection;

    public ReferenceBook (String title, String author, String ISBN, String callnum, String collection) {
	super (title, author, ISBN, callnum);
	this.collection = collection;
    }

    public String getCollection () {return collection;}

    public void setCollection (String collection) {this.collection = collection;}

    public String circulationStatus () {return "non-circulating reference book";}

    public void checkout (String patron, String due) {
	System.out.println ("cannot check out a reference book");
    }

    public void returned () {
	System.out.println ("reference book could not have been checked out - return impossible");
    }

    public String toString () {
	return super.toString() + "Collection: " + collection + "\n";
    }

}

class CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;

    public CirculatingBook (String title, String author, String ISBN, String callnum){
	super(title,author,ISBN,callnum);
	currentHolder = "null";
	dueDate = "null";
    }

    public String getCurrentHolder () {return currentHolder;}

    public String getDueDate () {return dueDate;}

    public void setCurrentHolder (String holder) {currentHolder = holder;}

    public void setDueDate (String duedate) {dueDate = duedate;}

    public void checkout (String patron, String date) {
	System.out.println ("\n" + this.getTitle() + "was successfully checked out\n");
	currentHolder = patron;
	dueDate = date;
    }

    public void returned () {
	System.out.println ("\n" + this.getTitle() + " was successfully returned\n");
	currentHolder = "null";
	dueDate = "null";
    }

    public String circulationStatus () {
	if (currentHolder.equals( "null") && dueDate.equals( "null")) {
	    return "book available on shelves";
	}
	else {
	    return "Current Holder: " + currentHolder + "\nDue Date: " + dueDate + "\n";
	}
    }

    public String toString () {
	if (!circulationStatus().equals ("book available on shelves")) {
	    return super.toString() + circulationStatus();
	} else {
	    return super.toString();
	}
    }

}
