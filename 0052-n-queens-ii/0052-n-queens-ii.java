class Solution {
    private int count;
    private boolean[] cols;
    private boolean[] diag1;   // main diagonal: row - col + n - 1
    private boolean[] diag2;   // anti-diagonal: row + col

    public int totalNQueens(int n) {
        count = 0;
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        backtrack(0, n);
        return count;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row - c + n - 1;
            int d2 = row + c;

            if (cols[c] || diag1[d1] || diag2[d2]) continue;

            // place queen
            cols[c] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n);

            // remove queen (backtrack)
            cols[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}