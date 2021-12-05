/**
 *  Approach 2:
 *  
 *  = An alternative recursive method =
 * 
 *  - An alternative algorithm involves reducing the problem recursively by specifying one of the coins.
 *    - For example,
 *      for 63 cents. we can give change in the following ways:
 *      
 *      - One 1-cent piece plus 62 cents recursively distributed
 *      - One 5-cent piece plus 58 cents recursively distributed
 *      - One 10-cent piece plus 53 cents recursively distributed
 *      - One 21-cent piece plus 42 cents recursively distributed
 *      - One 25-cent piece plus 38 cents recursively distributed
 *      
 *      One coins of different type add the rest of types of coins     
 *      1 + 21 21 10 10
 *      5 + 25 21 10 1 1
 *      10 + 21 21 10 1
 *      21 + 21 21
 *      25 + 25 10 1 1 1
 *      
 *      
 *  - Instead of solving 62 recursive problems, we get by with only 5 recursive calls, one for each different coin.
 *  - A naive recursive implementation is very inefficient because it recomputes answers.
 *  - For example, in the first case we are left with a problem of making 62 cents in change.
 *  
 *  - In this sub problem, one of the recursive calls made choose a 10-cent piece and recursively solve for 52 cents. 
 *  - In the third case we are left with 53 cents.
 *  - One of its recursive calls removes the 1-cent piece and also recursively solves for 52 cents.
 *  - This redundant work again leads to excessive running time.
 *  
 *  - If we are careful, however, we can make the algorithm run reasonably fast.
 *  
 *  
 *  Approach 3:
 *  
 *  = Dynamic Programming =
 *  
 *   - The trick is to save answers to the subproblems in an array.
 *   - This dynamic programming technique forms the basis of many algorithms.
 *   - A large answer depends only on smaller answers, so we can compute the optimal way to change 1 cent, then 2 cents, then 3 cents, and so on.
 *   - This strategy is shown in the code below.
 *   
 *   Algorithm:
 *   
 *   - First, at line 8 we observe that 0 cents can be changed using zero coins.
 *   - The lastCoin array is used to tell us which coin was last used to make the optimal change.
 *   
 *   - Otherwise, we attempt to make cents worth of change, for cents ranging from 1 to final maxChange.
 *   - To make cents worth of change, we try each coin in succession as indicated by the for statement beginning at line 15.
 *   
 *   - If the amount of the coin is larger than the amount of change we are trying to make, there is nothing to do.
 *   
 *   - Otherwise, we test at line 19 to determine whether the number of coins used to solve the subproblem plus the one coin combine 
 *     to be fewer than the minimum number of coins used thus far; if so,
 *     we perform an update at line 21 and line 22.
 *   
 *   - When the loop ends for the current number of cents, the minimums can be inserted in the arrays,
 *     which is done at line 26 and 27.
 *    
 *   - At the end of the algorithm, coinsUsedp[i] represents the minimum number of coins needed to make change
 *     for i cents( i == maxChange is the particular solution that we are looking for).
 *   - By tracing back through lastCoin, we can figure out the coins needed to achieve the solution.    
 *   
 *   Time Complexity:
 *   
 *   - The running time is that of 2 nested for loops and is thus O(NK),
 *     where N is the number of different denominations of coins and K is the amount of change that we are trying to make. 
 *
 */

public class DynamicProgrammingCoinChanging {

	// Dynamic programming algorithm to solve change-making problem.
	// As a result, the coinUsed array is filled with the minimum number of coins
	// needed for change from 0 -> maxChange
	// and lastCoin contains one of the coins needed to make the change.
	public static void makeChange(int[] coins, int differentCoins, int maxChange, int[] coinsUsed, int[] lastCoin) {

		// 0 cents can be changed using zero coins
		coinsUsed[0] = 0;
		lastCoin[0] = 1;

		// macChange = 20
		// int[] coins ={1, 5, 10}
		// differentCoins = 3

		// cents = 1 ~ 20
		for (int cents = 1; cents <= maxChange; cents++) {

			int minCoins = cents;
			int newCoin = 1;

			// j = 0 ~ 2
			for (int j = 0; j < differentCoins; j++) {

				// coins[0] = 1
				// 1>1

				if (coins[j] > cents) // Cannot use coin j. // the amount of the coin is larger than the amount of
										// change we are trying to make, there is nothing to do
					continue;

				// if the number of coins used to solve the subproblem plus the one coin combine
				// to be fewer than the minimum number of coins used,
				// then update the minCoins and newCoin
				if (coinsUsed[cents - coins[j]] + 1 < minCoins) {
					minCoins = coinsUsed[cents - coins[j]] + 1;
					newCoin = coins[j];

				}
			}
			coinsUsed[cents] = minCoins; // represents the minimum number of coins
			lastCoin[cents] = newCoin; // which coin was last used to make the optimal change
		}

	}

	public static void main(String[] args) {

		// The coins and the total amount of change
		int numCoins = 5;
		int[] coins = { 1, 5, 10, 21, 25 };
		int change = 0;

		String a[] = { "59" };
		/*
		 * Best is 6 coins
		 *  1
		 *  1
		 *  1
		 *  10
		 *  21
		 *  25
		 */

		if (a.length == 0) {
			System.out.println("Supply a monetary amount on the command line"); 
			System.exit(0);
		}

		try {
			change = Integer.parseInt(a[0]);
		} catch (NumberFormatException e) {
			System.out.println(e);
			System.exit(0);
		}
		int[] used = new int[change + 1];
		int[] last = new int[change + 1];

		makeChange(coins, numCoins, change, used, last);

		System.out.println("Best is " + used[change] + " coins");

		for (int i = change; i > 0;) {

			System.out.println(last[i] + " ");
			i -= last[i];

		}
		System.out.println();

	}

}
