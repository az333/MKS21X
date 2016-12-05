public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
  
    //0
    //constructor make an empty superArray should make size 0, 
    //but the data capacity 10.

    public SuperArray(){
	size = 0;
	data= new String[10];
    }

    public SuperArray(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	else {
	    String[] temp = new String[initialCapacity];
	    data=temp;
	    size=0;
	}
    }
    public SuperArray(String[] ary){
	data=ary;
	size=data.length;
    }

    public int size(){
	return size;
    }

    //1
    /**add the value n to the next available slot in the superArray.
     *this will change the size. This function should always work
     *And will resize the SuperArray if needed.*/
    /*    public void add(int n){
	  if (size <  data.length){
	  data[size] = n;
	  size+=1;
	  }
	  else{
	  grow();
	  data[size]=n;
	  size+=1;
	  }
	  }*/

    //2
    /**Resize the data, by making a new array, then copying over elements, use this as your d    */

    private void grow(){
	String[] newL= new String[data.length*2];
	for (int x =0; x<size;x++){
	    newL[x]=data[x];
	}
	data=newL;
    }

    //3
    /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
     *commas between... square bracket start/end and no comma at end.*/
    public String toString(){
	String ans="[";
	for (int x =0; x < size; x++){
	    if (x == size - 1){
		ans += data[x] + "]";
	    }
	    else{
		ans+= data[x]+ ", ";
	    }
	}
	return ans;
    }

    //4
    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
     *(capacity is 10, but only 6 are used)
     *commas between... square bracket start/end and no comma at end.
     *unused slots should be printed as _ (underscores) */
    public String toStringDebug(){
	String ans ="[";
	for (int x =0; x < data.length; x++){
	    if (x==size-1 && x==data.length-1){
		ans+=data[x]+"]";
	    }
	    else if(x==data.length-1){
		ans+="_]";
	    }
	    else if(x < size){
		ans+=data[x]+", ";
	    }
	    else{
		ans+="_, ";
	    }
	}
	//	System.out.println(ans);
	return ans;	  
    }
    public boolean add(String element){
	boolean res=false;
	if (size==data.length){
	    grow();
	}
	data[size]= element;
	size++;
	res=true;
	//	System.out.println(res);
	return res;
    }
    public String get(int index){
    	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
    	}
	return data[index];
    }
    
    public void clear(){
	size=0;
    }
    
    public boolean isEmpty(){
	return size ==0;
    }
    
    public String set(int index, String element){
    	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
    	}
	data[index]=element;
	return data[index];
    }
    
    public void add(int index, String element) {
	
	if (data.length== size) {
	    grow();
	}
        if (index < 0 || index >= data.length) {
	    throw new IndexOutOfBoundsException();
	}

	String[] temp= new String[data.length];
	for (int x =0; x < index; x++){
	    temp[x]=data[x];
	}
	temp[index]=element;
	size++;
	for (int x=index+1;x<size;x++){
	    temp[x]=data[x-1];
	}
	data=temp;
    }
    
    public String remove(int index) {

	if (index < 0 || index >= data.length) {
	    throw new IndexOutOfBoundsException();
	}

	String temp = data[index];
	for (int x = index; x < size - 1; x++) {
	    data[x] = data[x + 1];
	}
	size--;
	return temp;
    }
    
    public String[] toArray(){
	String[] temp= new String[size];
	for (int x = 0; x<size; x++){
	    temp[x]=data[x];
	}
	return temp;
    }
    
    public int indexOf(String i){
	int res=0;
	for (int x=0;x<size;x++){
	    if (data[x].equals(i)){
		res = x;
		break;
	    }
	    else {
		res = -1;
	    }
	}
	return res;
    }
    
    public int lastIndexOf(String i){
	int res=0;
	for (int x=0;x<size;x++){
	    if (data[x].equals(i)){
		res = x;
	    }
	    else { res = -1;}
	}
	return res;
    }

    public void trimToSize() {
	String[] temp = new String[size];
	for(int x = 0; x < size;x++){
            temp[x] = data[x];
        }
        data = temp;
    }
    public SuperArrayIterator iterator(){
	return new SuperArrayIterator(this);
    }
	
    /*public static void main(String[]args){
      SuperArray L1,L2;
      String[] list= new String[3];
      list[0]="Hello";
      list[1]="world";
      list[2]="It's me!";
      L1= new SuperArray(list);
      System.out.println(L1.toString());
      L1.add(2,"great");
      System.out.println(L1.toString());
      L1.remove(1);
      System.out.println(L1.toString());
      }*/
}
