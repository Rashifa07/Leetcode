class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentComb, int start, int n, int k) {
        // Base case: if the combination is done
        if (currentComb.size() == k) {
            result.add(new ArrayList<>(currentComb));
            return;
        }
        for (int i = start; i <= n - (k - currentComb.size()) + 1; i++) {
            currentComb.add(i);                            // Make a choice
            backtrack(result, currentComb, i + 1, n, k);   // Recurse
            currentComb.remove(currentComb.size() - 1);    // Undo the choice (backtrack)
        }
    }
}