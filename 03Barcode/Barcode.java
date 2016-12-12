public class Barcode implements Comparable<Barcode> {
    private String _zip;
    private static final String[] bars =
    { "||:::", ":::||", "::|:|", "::||:",
      ":|::|", ":|:|:", ":||::", "|:::|",
      "|::|:", "|:|::" } ;

    public Barcode (String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException ("Zip is not the correct length");
	}

	try {
	    int zipnum = Integer.parseInt(zip); 
	}
	catch (NumberFormatException e) {
	    throw new IllegalArgumentException ("Zip contains a non digit");
	}
	_zip = zip;
	//System.out.println ("zip: " + _zip);
    }

    public Barcode clone () {
	Barcode a = new Barcode (_zip);
	return a;
    }

    public static int checkSum (String zip) {
	int zipsum = Integer.parseInt(zip);
	int sum = 0;
	while ( zipsum > 0) {
	    sum += zipsum % 10;
	    zipsum /= 10;
	}
	return sum % 10;
    }

    public static String fullZip (String zip) {
	String newzip = zip + checkSum (zip);
	return newzip;
    }
    
    public static String toCode (String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException ("Zip is not the correct length");
	}
	try {
	    int zipnum =  Integer.parseInt(zip);
	} catch (NumberFormatException e) {
	    throw new IllegalArgumentException ("Zip contains a non digit");
	}
		
	String barcode = "|";
	char[] zipary = fullZip(zip).toCharArray ();
	for (char c: zipary) {
	    switch (c) {
	    case '0': barcode += bars[0];
		break; 
	    case '1': barcode +=  bars[1];
		break;
	    case '2': barcode +=  bars[2];
		break;
	    case '3': barcode += bars[3];
		break;
	    case '4': barcode += bars[4];
		break;
	    case '5':barcode +=  bars[5];
		break;
	    case '6':barcode +=  bars[6];
		break;
	    case '7': barcode += bars[7];
		break;
	    case '8':barcode += bars[8];
		break;
	    case '9':barcode += bars[9];
		break;
	    }
  
	}
	barcode += "|"; 
	return barcode; 
    }

    public String toString () {
	String barcode = toCode(_zip);
	//	System.out.println ("length: " + barcode.length());
	return  fullZip(_zip) + " " + barcode;
    } 
	
	
    public int compareTo (Barcode other) {
	return _zip.compareTo(other._zip);
    }

    public static String toZip (String code) {
	
	if (code.length() != 32) {
	    throw new  IllegalArgumentException ("The length of the barcode is not 32 ");
	}if (code.charAt(0) != '|'  ||  code.charAt(code.length() - 1) != '|') {
	    throw new IllegalArgumentException ("The left and rigthmost charcters are not '|' ");
	}for (int i = 0; i < code.length(); i ++) {
	    if (code.charAt(i) != '|' && code.charAt(i) != ':') {
		throw new IllegalArgumentException ("Non-barcode characters are used");
	    }
	}
	//	System.out.println(code);
	
	//going through each "section" of the barcode loop
	for (int i = 1; i < code.length () - 5; i += 5) {
	  
	    //checking for matches loop 
	    for (int x = 0; x < bars.length; x ++) {
		if (code.substring(i, i + 5).equals(bars[x])) {
		    //System.out.println (code.substring(i, i +5));
		    break;
		}
		if (x == bars.length - 1) {
		    throw new IllegalArgumentException("Encoded ints are invalid");
		 }
	    }
	}
	
	int sum = 0;
	for (int i = 1; i < code.length() - 10; i += 5) {
	    for (int x = 0; x < bars.length; x ++) {
		if (code.substring(i, i + 5).equals (bars[x])) {
		    //System.out.println(code);
		    //System.out.println(code.substring(i,i + 5));
		    // System.out.println (x);
		    sum += x;
		}
	    }
	}
	int checksum = 0;
	for (int x = 0; x < bars.length; x ++) {
	    if (code.substring(26, 31).equals( bars[x])) {
		    checksum = x;
	    }
	}
	if (checksum != sum % 10) {
	    throw new  IllegalArgumentException ("Checksum is invalid");
	}
	
	String zip = "";
	for (int i = 1; i < code.length() - 10; i += 5) {
	    for (int x = 0; x < bars.length; x ++) {
		if (code.substring(i, i + 5).equals(bars[x])){
		    zip += x;
		}
	    }
	}
	return zip;
    }
		

	

}
