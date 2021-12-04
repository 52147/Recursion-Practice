/**
 * 
 * = printing numbers in any base = 
 * 
 *  - A good example of how recursion simplifies the coding of routines is number printing.
 *  
 *  - Suppose that we want to print out a nonnegative number N in decimal form but that we do not have a number output function available.
 *  
 *  - However, we can print out one digit at a time.
 *  - Consider, for instance, how we would print the number 1369.
 *  - First we would need to print 1, then 3, then 6, and then 9.
 *  
 *  - The problem is that obtaining the first digit is a bit sloppy:
 *    
 *    - Given a number n, we need a loop to determine the first digit of n.
 *    - In contrast is the last digit, which is immediately available as n%10 (which is n for n less than 10).
 *    
 *    
 *  - Recursion provides a nifty solution:
 *  
 *  - To print out 1369, we print out 136, follow by the last digit 9.
 *  - As we have mentioned, printing out the last digit using the % operator is easy.
 *  - Printing out all but the number represented by eliminating the last digit also is easy, because it is the same problem as printing out n/10.
 *  - Thus, it can be done by recursive call.
 *  
 *  
 *  - The code shown in this program implements this printing routine.
 *  - If n is smaller than 10, line 6 is not executed and only the one digit n%10 is printed;
 *    otherwise, all but the last digit are printed recursively and then the last digit is printed.
 *    
 * 
 *  - Note how we have a base case(n is a one-digit integer), and because the recursive problem has one less digit, 
 *    all recursive calls progress toward the base case.
 *  - Thus we have satisfied the first 2 fundamental rules of recursion.
 *  
 *  
 *   printInt method:
 *   
 *  - To make our printing routine useful, we can extend it to print in any base between 2 and 16^2.
 *  
 *  - We introduced a String to make the printing of a through f easier.
 *  - Each digit is now output by indexing to the DIGIT_TABLE string. 
 *         
 *  - The printInt routine is not robust.
 *  - If base is larger than 16, the index to DIGIT_TABLE could be out of bounds.
 *  - If base is 0, an arithmetic error results when division by 0 is attempted at line 8.
 *  
 *  - The most interesting error occurs when base is 1.
 *  - Then the recursive call at line 8 fails to make progress because the two parameters to the recursive call are identical to the original call.
 *  - Thus the system makes recursive calls until it eventually runs out of bookkeeping space(and exit less than gracefully). 
 *
 */

import java.util.Scanner;

public class PrintNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		
		printDecimal(n);
		
		long a1 = scanner.nextLong();
		int a2 = scanner.nextInt();
		printInt(a1,a2);
		

	}
	
	// Print n in base 10, recursively.
	// Precondition: n>=10
	public static void printDecimal(long n) {		
		if(n >= 10)
			printDecimal(n/10);
		System.out.println((n % 10));
		
	}
	
	private static final String DIGIT_TABLE = "0123456789abcdef";
	
	// Print n in any base, recursively.
	// Precondition: n>=0, base is valid.
	
	// 10, 2 -> DIGIT_TABLE.charAt((int)(n % base) = 1
	// 5,2 -> DIGIT_TABLE.charAt((int)(n % base) = 0
	// 2,2 -> DIGIT_TABLE.charAt((int)(n % base) = 1
	// 1, 2 -> DIGIT_TABLE.charAt((int)(n % base) = 0
	
	public static void printInt(long n, int base) { 
		
		if(n >= base) 
			printInt(n/base,base);
		
		System.out.println(DIGIT_TABLE.charAt((int)(n % base)));
	}

}
