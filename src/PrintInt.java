/**
 *  - We can make the routine more robust by adding an explicit test for base.
 *  - The problem with this tragedy is that the test would be executed during each of the recursive calls to printInt,
 *    not just during the first call.
 *    
 *  - Once base is valid in the first call, to retest it is silly because it does not change in the course of the recursion 
 *    and thus must still be valid.
 *  - One way to avoid this inefficiency is to set up a driver routine.
 *  - The use of driver routines for recursive programs is a common technique.
 *  
 *  Driver routine:
 *   - A driver routine tests the validity of the first call and then calls the recursive routine.
 *
 */
public final class PrintInt {
	
	private static final String DIGIT_TABLE = "0123456789abcdef";
	private static final int MAX_BASE = DIGIT_TABLE.length();
	
	// Print n in any base, recursively
	// Precondition: n >= 0, 2 <= base <= MAX_BASE
	private static void printIntRec(long n, int base) {
		if(n >= base)
			printIntRec(n/base,base);
		System.out.println(DIGIT_TABLE.charAt((int)(n % base)));
		
	}
	
	// Driver routine
	public static void printInt(long n, int base) {
		
		// Check the first call is validity
		if(base <= 1 || base > MAX_BASE)
			System.err.println("Cannot print in base " + base);
		else {
			if(n<0) {
				n = -n;
				System.out.println("-");
			}
			printIntRec(n, base);
		}
	}
			
	

	public static void main(String[] args) {
		
		printInt(223,5);
		
		System.out.println();

		printInt(40,5);
		
		System.out.println();
		
		printInt(40, 19);
		
		System.out.println();
		
		printInt(40,-3);
		
		System.out.println();
				
		printInt(40, 3);
		
		System.out.println();
		
		printInt(-40, 3);

	}

}
