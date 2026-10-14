import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result);
        return result;
    }
    
    private void backtrack(int start, int[] nums, List<List<Integer>> result) {
        // If we've reached the end of the array, add the current permutation
        if (start == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            // Swap to place the chosen element at the 'start' index
            swap(nums, start, i);
            // Recurse for the next position
            backtrack(start + 1, nums, result);
            // Backtrack by swapping the elements back to their original positions
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}