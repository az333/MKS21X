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


}
