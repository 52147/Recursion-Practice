/**
 * 
 * = binary search =
 * 
 *  - In a binary search, we perform a search in sorted array "a" by examining the middle element.
 *  - If we have a match, we are done.
 *  
 *  - Otherwise, if the item being searched for is smaller than the middle element, we search in the subarray that is to the left of the middle element.
 *  
 *  - Otherwise, we search in the subarray that is to the right of the middle element.
 *  
 *  - This procedure presumes that the subarray is not empty; if it is, the item is not found.
 *  
 *  
 *  - This description translates directly into the recursive method.
 *  - The code illustrates a thematic technique in which the public driver routine makes an initial call to a recursive routine and passes on the return value.
 *  - The driver sets the low and high points of the subarray, namely, 0 and a.length-1.
 *  
 *  
 *  - In the recursive method, the base case at lines 18 and 19 handles an empty subarray.
 *  - Otherwise, we follow the description given previously by making a recursive call on the appropriate subarray (line 24 or 26)
 *    if a match has not been detected.
 *  - When a match is detected, the matching index is returned at line 28.
 *  
 *  
 *  - Note that the running time, in terms of Big-Oh, is unchanged from the nonrecursive implementation because we are performing the same work.
 *  - In practice, the running time would be expected to be slightly larger because of the hidden costs of recursion. 
 *
 */
public class BinarySearch {

	private static final int NOT_FOUND = -1;

	/**
	 * Perform the standard binary search using two comparisons per level. This is a
	 * driver that calls the recursive method.
	 * 
	 * @return index where item is found or NOT_FOUND if not found.
	 *
	 */

	public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x) {

		return binarySearch(a, x, 0, (a.length - 1));

	}

	/**
	 * Hidden recursive routine.
	 */
	private static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x, int low,
			int high) {
		
		if (low > high)
			return NOT_FOUND;

		int mid = (low + high) / 2; // mid = 4 // 6
		
		// if x is smaller than the middle element, search left of the middle element.
		if (a[mid].compareTo(x) < 0) // 4<6 
			return binarySearch(a, x, mid + 1, high); //5,7
		
		// if x is bigger than the middle element, search right of the middle element.
		else if (a[mid].compareTo(x) > 0)
			return binarySearch(a, x, low, mid - 1);
		else
			return mid;
	}

	public static void main(String[] args) {
		Comparable[] a = { 1, 3, 4, 5, 6, 7 };
		Comparable x = 6;
		System.out.println(binarySearch(a, x, 1, 7)); // return the answer that 6 is at which index in array a.

	}

}
