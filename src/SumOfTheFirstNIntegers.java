/**
 * 
 * = recursion =
 * 
 *  - A recursive method is a method that either directly or indirectly makes a call to itself.
 *  - This action may seem to be a circular logic:
 *    
 *    How can a method F solve a problem by calling itself?
 *    - The following are some examples.
 *    
 *    1.
 *    - Files on a computer are generally stored in directories.
 *    - Users may create subdirectories that store more files and directories.
 *    - Suppose that we want to examine every file in a directory D, including all files in all subdirectories(and subsubdirectories, and so on).
 *    - We do so by recursively examining every file in each subdirectory and then examining all files in the directory D.
 *    
 *    2.
 *    - Suppose that we have large dictionary.
 *    - Words in dictionaries are defined in terms of other words.
 *    - When we look up the meaning of a word, we might not always understand the definition,
 *      so we might have to look up words in the definition.
 *    
 *    - Likewise, we might not understand some of those, so we might have to continue this search for a while.
 *    - As the dictionary is finite, eventually either we come to a point where we understand all the words in some definition.
 *      (and thus understand that definition and can retrace our path through the other definitions),
 *      we find that the definitions are circular and that we are stuck, or some word we need to under is not defined in the dictionary.
 *      
 *    - Our recursive strategy to understand words is as follows:
 *      
 *      - If we know the meaning of a word, we are done;
 *        otherwise, we look the word up in the dictionary.
 *      - If we understand all the words in the definition, we are done.
 *        Otherwise, we figure out what the definition means by recursively looking up the words that we do not know.
 *        
 *      - This procedure terminates if the dictionary is well defined, but it can loop indefinitely if a word is circularly defined.
 *           
 *    3.
 *    - Computer languages are frequently defined recursively.
 *      - For instance, an arithmetic expression is an object, or a parenthesized expression, or two expressions added to each other, and so on.
 * 
 * 
 * = basic recursion =
 *  
 *  - Proof by induction show us that, if we know that a statement is true for a smallest case and can show that one case implies the next case,
 *    then we know the statement is true for all cases.
 *    
 *  - Sometimes mathematical functions are defined recursively.
 *  
 *    - For instance, let S(N) be the sum of the first N integers.
 *      - Then S(1) = 1, and we can write S(N) = S(N-1)+N.
 *      - Here we have defined the function S in terms of a smaller instance of itself.
 *      - The recursive definition of S(N) is virtually identical to the closed form S(N) = N(N+1)/2, 
 *        with the exception that the recursive definition is only defined for positive integers and is less directly computable.
 *         
 *   -> 
 *   - A recursive method is defined in terms of a smaller instance of itself.
 *   - There must be some base case that can be computed without recursion.
 *      
 */
/**
 *  
 *  = recursive method for sum of the first n integers = 
 *  
 *  - Sometimes writing a formula recursively is easier than writing it in closed form.
 *  - This program shows a straightforward implementation of the recursive function.
 *  
 *  - If N = 1, we have the basis, for which we know S(1) = 1.
 *  - Otherwise, we follow the recursive definition S(N) = S(N-1) + N.
 *  - It is hard to imagine that we could implement the recursive method ant more simply than this, so the natural question is, does it actually work?
 *  
 *  
 *  - The answer is that this routine works.
 *  - Let us examine how the call to s(4) is evaluated.
 *  - s(4) -> s(3) -> s(2) -> s(1)
 *  - Now we have n equal to 1, so s(1) returns 1.
 *  - At this points s(2) can continue, adding the return value from s(1) to 2, thus s(2) return 3.
 *  - Now s(3) continues, adding the value of 3 returned by s(2) to n, which is 3; thus s(3) returns 6.
 *  - This result enable completion of the call to s(4), which finally return 10.
 *  
 *  - base case: s(1) = 1
 *  - recursively formula: s(n) = s(n-1) + n
 *  
 *  - Q: s(4) = ?
 *  
 *  - A:
 *    - s(1) = 1
 *    - s(2) = s(1) + 2 = 3
 *    - s(3) = s(2) + 3 = 6 
 *    - s(4) = s(3) + 4 = 10
 *    
 *  - Note that, although s seems to be calling itself, in reality it is calling a clone of itself.
 *  - That clone is simply another method with different parameters.
 *  - At any instant only one clone is active; the rest are pending.
 *  - It is the computer's job, not yours, to handle all the bookkeeping.
 *  - If there were too much bookkeeping even for the computer, then it would be time to worry.
 *  
 *  = Base case =
 *  
 *   - A base case is an instance that can be solved without recursion.
 *   - Any recursive call must progress toward the base case in order to terminate eventually.
 *   - We thus have our two of four fundamental rules of recursion.
 *   
 *    1. Base case:
 *       - Always have at least one case that can be solved without using recursion.
 *    2. Make progress:
 *       - Any recursive call must progress toward a base case.
 *       
 *          
 *  - Our recursive evaluation routine does have a few problems.
 *  
 *  Problem:
 *  
 *  1.
 *  - One is the call s(0), for which the method behaves poorly.
 *    
 *    -> 
 *    - A call to s(-1) is made, and the program eventually crashed because there are too many pending recursive calls.         
 *    - The recursive calls are not progressing toward a base case.
 *    
 *  - This behavior is natural because the recursive definition of s(n) does not allow n<1.
 *  - We can fix this problem by extending the definition of s(n) to include n=0.
 *  
 *  - Because there are no numbers to add in this case, a natural value for s(0) would be 0.
 *  - This value makes sense because the recursive definition can apply for s(1), as s(0)+1 = 1
 *  
 *  - To implement this change, we just replace 1 with 0.
 *  - Negative n also causes error, but this problem can be fixed in a similar manner.
 *  
 *  2.
 *  - A second problem is that if the parameter n is large, but not so large that the answer does not fit in an int, the program can crash or hang.
 *  -  Our system, for instance, cannot handle n>= 8822
 *  - The reason is that, as we have shown, the implementation of recursion requires some bookkeeping to keep track of the pending recursive calls,
 *    and for sufficiently long chains of recursion, the computer simply runs out of memory.
 *  - This routine also is somewhat time consuming than an equivalent loop because the bookkeeping also uses some time.
 *  
 *  
 * - Needle to say, this particular example does not demonstrate the best use of recursion because the problem is so easy to solve without recursion.
 * 
 * - Most of the good uses of recursion do not exhaust the computer's memory and only slightly more time consuming than nonrecursive implementations.
 * - However, recursion almost always leads to more compact code.  
 *    
 *    
 */

import java.util.Scanner;
public class SumOfTheFirstNIntegers {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		long ans = s(n);
		System.out.println(ans);
	}
	
	// n=2
	// return s(2-1) + 2 -> s(1) +2
	// n =1
	// return 1
	// 1 + 2 = 3
	// Recursive evaluation of the sum of the first n integers
	public static long s (int n) {
		if (n==0)
			return 0;
		/*
		if (n==1)
			return 1;
			*/
		else
			return s(n-1) + n;
	}

}
