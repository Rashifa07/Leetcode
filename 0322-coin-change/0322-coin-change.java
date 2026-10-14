import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize an array to store the minimum coins needed for each amount up to 'amount'.
        // Size is amount + 1, initialized with an amount + 1 value to act as infinity.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;
        
        // Iterate through all amounts from 1 to target amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still amount + 1, it means the amount cannot be made up by any combination
        return dp[amount] > amount ? -1 : dp[amount];
    }
}