/**
 * 
 * = Dynamic Programming =
 * 
 *  - A problem that can be mathematically expressed recursively can also be expressed as a recursive algorithm.
 *  - In many cases, doing so yields a significant performance improvement over a more naive exhaustive search.
 *  - Any recursive mathematical formula could be directly translated to a recursive algorithm,
 *    but often the compiler may not do justice to the recursive algorithm and an inefficient program results.
 *  - That is the case for the recursive computation of the Fibonacci numbers.
 *  
 *  - To avoid this recursive explosion, we can use dynamic programming to rewrite the recursive algorithm
 *    as a nonrecursive algorithm that systematically records the answers to the subproblems in a table.
 *    
 *    
 *    
 * = change- making problem =
 * 
 *   Q.
 *    - For a currency with coins C1, C2,...., CN(cents) what is the minimum number of coins needed to make K cents of change?
 *    
 *   - U.S. currency has coins in 1-, 5-, 10-, and 25-cent denominations (ignore the less frequently occurring 50-cent piece.)
 *   - We can make 63 cents by using two 25-cent pieces, one 10-cent piece, and three 1-cent pieces,
 *     for a total of 6 coins.
 *     
 *   - Change-making in this currency is relatively simple:
 *     
 *     - We repeatedly use the largest coin available to us.
 *     - We can show that for U.S. currency this approach always minimizes the total number of coins used,
 *       which is an example of so-called greedy algorithms.
 *       
 *      = Greedy Algorithms = 
 *     
 *     - In a greedy algorithm, during each phase, a decision is made that appears to be optimal,
 *       without regard for future consequences.
 *     - This "take what you can get now" strategy is the source of the name for this class of algorithm.
 *     - When a problem can be solved with a greedy algorithm, we are usually quite happy:
 *     
 *       - Greedy Algorithms often match our intuition and make for relatively painless coding.
 *       - Unfortunately, greedy algorithms do not always work.
 *       
 *       - If the U.S. currency included a 21-cent piece,
 *         the greedy algorithms would still give a solution that uses six coins, but the optimal solution uses 3 coins(all 21-cent pieces).
 * 
 * 
 * 
 *   Approach 1:
 *   
 *   = Recursive method =
 *   
 *   - The question then becomes one of how to solve the problem for an arbitrary coin set.
 *   - We assume that there is always a 1-cent coin so that the solution always exists.
 *   - A simple strategy to make K cents in change uses recursion as follows.
 *   
 *     1.
 *     - If we can make change using exactly one coin, that is the minimum.
 *     
 *     2.
 *     - Otherwise, for each possible value i we can compute the minimum number of coins needed to make i cents in change and K-i cents in change independently. 
 * 	   - We then choose the i that minimizes this sum.
 * 
 * 
 * 
 *   - For example, let us see how we can make 63 cents in change.
 *   - Clearly, one coin will not suffice.
 *   
 *   - We can compute the number of coins required to make 1 cent of change and 62 cents of change independently(these are 1 and 4, respectively).
 *   - We obtain these results recursively, so they must be taken as optimal (it happens that the 62 cents is given as two 21-cent pieces and two 10 cent pieces.)
 *   - Thus we have a method that uses five coins.
 *   
 *   - If we split the problem into 2 cents and 61 cents, the recursive solutions yield 2 and 4, respectively, for a total of six coins.
 *   
 *   - We continue trying all the possibilities.
 *   - Eventually, we see a split into 21 cents and 42 cents, which is changeable in one and two coins, respectively, thus allowing change to be made in three coins.
 *   
 *   - The last split we need to try is 31 cents and 32 cents.
 *   - We can change 31 cents in two coins, and we can change 32 cents in three coins for a total of five coins.
 *   - But the minimum remains three coins.
 *   
 *     Subproblems solved recursively:
 *     
 *      63 cents in change:
 *     
 *       1 cents: 1
 *       62 cents: 21 21 10 10      => total 4 coins
 *       -----------------------
 *       21 cents: 21
 *       42 cents: 21 21            => total 3 coins
 *       -----------------------
 *       2 cents: 1 1
 *       61 cents: 25 25 10 1       => total 6 coins
 *       -----------------------
 *       31 cents: 21 10
 *       32 cents: 21 10 1          => total 5 coins       
 *       
 *       
 *   - We solve each of these subproblems recursively, which yields the natural algorithm shown in code below.
 *   - If we run the algorithm to make small change, it works perfectly.
 *   - But like the Fibonacci calculations, the algorithm requires too much redundant work, 
 *     and it will not terminate in a reasonable amount of time for the 63-cent case.    
 *
 */
public class CoinChanging {
	
	// Return minimum number of coins to make change.
	// Simple recursive algorithm that is very inefficient
	public static int makeChange(int [] coins, int change) {
		
		int minCoins = change;
		
		for(int i = 0; i < coins.length;i++)
			if(coins[i] == change)
				return 1;
		
		//No match; solve recursively.
		for(int j = 1; j <= change/2; j++) { 
			// split the change to two pile
			// and handle each pile of the change then sum the total coins
			int thisCoins = makeChange(coins, j) + makeChange(coins, change - j);
			
			// Find the minimum number of the coins
			if(thisCoins < minCoins)
				minCoins = thisCoins;
		}
		return minCoins;
	}

	public static void main(String[] args) {
		
		// denominations of coin types 
		int[] a = {1, 5, 10, 25};
		
		System.out.println(makeChange(a, 13)); // change 13$

	}

}
