class Solution {
    int board[][];
    List<List<String>> res;
    int n;
    
    public List<List<String>> solveNQueens(int n) {
        board=new int[n][n];
        this.n=n;
        res=new ArrayList<>();
        nqueen(0);
        return res;
    }

    void nqueen(int q) {
        if(q==n) {
            res.add(contruct());
            return;
        }

        for(int i=0;i<n;i++) {
            if(safe(i,q)) {
                board[i][q]=1;
                nqueen(q+1);
                board[i][q]=0;
            }
        }
    }

    boolean safe(int row,int col) {
        for(int j=0;j<col;j++)
            if(board[row][j]==1)return false;

        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
            if(board[i][j]==1)return false;

        for(int i=row+1,j=col-1;i<n&&j>=0;i++,j--)
            if(board[i][j]==1)return false;

        return true;
    }

    List<String> contruct() {
        List<String> sol=new ArrayList<>();
        for(int i=0;i<n;i++) {
            StringBuilder cur=new StringBuilder();
            for(int j=0;j<n;j++) {
                if(board[i][j]==0)
                    cur.append('.');
                else if(board[i][j]==1)
                    cur.append('Q');
            }
            sol.add(cur.toString());
        }
        return sol;
    }
}