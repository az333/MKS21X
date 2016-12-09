public class CirculatingBook extends LibraryBook {
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
