import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String>{
    private int element;
    private SuperArray supa;

    public SuperArrayIterator(SuperArray a){
	supa = a;
	element=0;
    }
    public boolean hasNext(){
	return element < supa.size();
    }
    public String next(){
	if (hasNext()){
	    element++;
	    return supa.get(element-1);
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
    
	
