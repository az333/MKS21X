public class ReferenceBook extends LibraryBook {
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
