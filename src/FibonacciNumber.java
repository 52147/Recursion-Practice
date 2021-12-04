/**
 * 
 * = Too much recursion can be dangerous =
 * 
 *  - In this text we give many example of the power of recursion.
 *  - However, before we look at those examples, you should recognize that recursion is not always appropriate.
 *  
 *    - For instance, the use of recursion in sum of the first integers program is poor 
 *      because a loop would do just as well.
 *    
 *  - A practically liability is that the overhead of the recursive call takes time and limits the value of n for which the program is correct.
 *  - A good rule of a thumb is that you should never use recursion as a substitute for a simple loop.
 *  
 *  
 *  = Fibonacci number =
 *  
 *  - A much more serious problem is illustrated by an attempt to calculate the Fibonacci numbers recursively.
 *  
 *  - The Fibonacci numbers F0,F1,...Fi are defined as follows:
 *     
 *     F0 = 0  and F1 = 1; the i th Fibonacci number equals the sum of the (i th - 1) and (i th -2) Fibonacci numbers;
 *     thus Fi = Fi-1 + Fi-2
 *     
 *     - From this definition we can determine that the series of Fibonacci numbers continues:
 *       1,2,3,5,8,13,21,34,55,89....
 *       
 *  - The Fibonacci numbers have an incredible number of properties, which seem always to crop up.
 *  - In fact, one journal, The Fibonacci Quarterly, exists solely for the purpose of publishing theorems involving the Fibonacci numbers.
 *  
 *    - For instance, the sum of squares of two consecutive Fibonacci numbers is another Fibonacci number.   
 *    - The sum of the first N Fibonacci numbers is one less than F N+2   
 *    
 *  - Because the Fibonacci numbers are recursively defined, writing a recursive routine to determine FN seems natural.
 *  
 *  - This recursive routine, shown in this code works but has serious problem.
 *  - On our relatively fast machine, it takes nearly a minute to compute F40,
 *    an absurd amount of time considering that the basic calculation requires only 39 additions(+).
 *    
 *    
 *    A trace of the recursive calculation of the Fibonacci numbers.
 *    
 *               F5
 *            /     \
 *          F4      F3
 *          /\       /\
 *        F3 F2     F2 F1
 *       /\   /\     /\
 *     F2 F1 F1 F0  F1 F0
 *     /\
 *   F1  F0 
 *         
 *    - The underlying problem is that this recursive routine performs redundant calculation,
 *    - To compute fib(n), we recursively compute fib(n-1).
 *    - When the recursive returns, we compute fib(n-2) by using another recursive call.
 *    - But we have already computed fib(n-2) in the process of computing fib(n-1),
 *      so the call to fib(n-2) is a wasted, redundant calculation.
 *    - In effect, we make 2 calls to fib(n-2) instead of only 1.
 *    
 *    
 *    - Normally, making 2 method calls instead of 1 would only double the running time of a program.
 *    - However, here it is worse than that:
 *      
 *      - Each call to fib(n-1) and each call to fib(n-2) makes a call to fib(n-3);
 *        thus there are actually 3 calls to fib(n-3).
 *        
 *      - In fact, it keeps getting worse:
 *        Each call to fib(n-2) or fib(n-3) result in a call to fib(n-4), so there are 5 calls to fib(n-4).
 *        
 *      - Thus  we get a compounding effect:
 *        Each recursive call does more and more redundant work.
 *        
 *    - Let C(N) be the number of calls to fib made during the evaluation of fib(n).
 *    - Clearly C(0) = C(1) = 1 call. 
 *    
 *    - For N >= 2, we call fib(n), plus all the calls needed to evaluate fib(n-1) and fib(n-2) recursively and independently.
 *    - Thus C(N) = C(N-1) + C(N-2) + 1
 *    
 *    - By induction, we can easily verify that for N>=3 the solution to this recurrence is C(N) = Fn+2 +Fn-1 - 1.
 *    
 *    - Thus the number of recursive calls is more than the 300000000.
 *    - No wonder the program takes forever.
 *    - The explosive growth of the number of recursive calls is illustrated in this program.    
 *    
 *       
 *  - This example illustrates the fourth and final basic rule of recursion.
 *  
 *     4. Compound interest rule:
 *        
 *        Never duplicate work by solving the same instance of a problem in separate recursive calls. 
 *
 */
public class FibonacciNumber {
	
	// A¡@recursive routine for Fibinacci numbers.
	// Compute the Nth Fibonacci number.
	// Bad algorithm.	
	public static long fib(int n) {
		
		if(n <= 1)
			return n;
		else
			return fib(n-1)+fib(n-2);
	}

}
