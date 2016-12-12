public class Tester2 {

    // KHINSHAN KHAN'S TESTS

    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
      
	System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|")+Barcode.checkSum("08451")+" "+Barcode.toCode("08451"));//same as above
	System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(Barcode.toCode("08451").compareTo("|||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println((new Barcode("11426")).compareTo(new Barcode("11426"))); //0
	System.out.println((new Barcode("99999")).compareTo(b)); //some positive, preferably 1
	System.out.println((new Barcode("01111")).compareTo(b)); //some negative, preferably -1
	System.out.println(b.compareTo(new Barcode("01111"))); //some negative, preferably 1
	System.out.println(b.compareTo(new Barcode("99999"))); //some positive, preferably -1
	int sum= 0;
	try{
	    //length
	    System.out.println((new Barcode("123456")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //length
	    System.out.println(Barcode.toCode("123456"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //length
	    System.out.println((new Barcode("1234")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //length
	    System.out.println(Barcode.toCode("1234"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //type
	    System.out.println((new Barcode("12.45")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //type
	    System.out.println(Barcode.toCode("12.45"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //type
	    System.out.println((new Barcode("12a45")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //type
	    System.out.println(Barcode.toCode("12a45"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //type
	    System.out.println((new Barcode("12/45")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //type
	    System.out.println(Barcode.toCode("12/45"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //length
	    System.out.println(Barcode.toZip("|||:::|:::|::|::|:|:|::::|||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //length
	    System.out.println(Barcode.toZip("|||:::|::|::|::||:|::::|||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //nonbarcode char were used
	    System.out.println(Barcode.toZip("|||:::|::|::|a:|:|:|::::|||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //nonbarcode char were used
	    System.out.println(Barcode.toZip("|||::::::|::||||:|:|:::::||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //checkSum is wrong
	    System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::||||:::|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //left or right is wrong
	    System.out.println(Barcode.toZip(":||:::|::|::|::|:|:|::::||||:::|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	    //left or right is wrong
	    System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::||||::::"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	System.out.println("\nThere were 17 errors, if youre not interested in type, just look below to make \nsure there are 17 lol\n");
	System.out.println("The number of errors caught were: "+ sum);
    }

}
