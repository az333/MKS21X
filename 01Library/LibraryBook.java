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
