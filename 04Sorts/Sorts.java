public class Sorts{

    
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "06.Angelica.Zverovich"; 
    }


    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	for (int i = 0; i < data.length - 1; i ++) {
	    int min = data[i];
	    int minindex = i; 
	    for (int x = i + 1; x < data.length; x ++) {
		if (min > data[x]) {
		    min = data[x];
		    minindex = x;
		}
	    }
	    int temp = data[i]; 
	    data[i] = min;
	    data[minindex] = temp; 
	    
	}
    }


    public static void insertionSort (int [] data) {
	// make i = 1 because first element is already sorted
	for (int i = 1; i < data.length; i ++) {
	    
	    //temp number we want to move
	    int temp = data[i];
	    
	    //index right before temp number 
	    int x = i - 1;

	    //starting at index right before, go down the list as long as the temp is smaller than the list item 
	    for (; x > -1  && temp < data[x]; x --) {

		//set each element to the one before  
		data[x + 1] = data[x];		    
	    }

	    // place the temp in the correct spot 
	    data[x + 1] = temp;
	}
    }


    public static void bubbleSort (int [] data) {
	int max = data.length; 
	for (int i = 0; i < data.length; i ++) {
	    int temp;
	    boolean swaps = false; 
	    for (int x = 1; x < max ; x ++) {
		if (data[x - 1] > data[x]) {
		    temp  = data[x - 1];
		    data[x - 1] = data[x];
		    data[x] = temp;
		    swaps = true;
		}
	    }
	    if (swaps == false) {
		return;
	    }
	    max --;    
	}
    }
}
