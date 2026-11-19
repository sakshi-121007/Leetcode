import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.err.println("Please provide the board size as an integer.");
            return;
        }

        int n = scanner.nextInt();
        if (n < 1) {
            System.err.println("The board size must be at least 1.");
            return;
        }

        List<List<String>> solutions = new NQueens().solveNQueens(n);
        if (solutions.isEmpty()) {
            System.out.println("No solutions.");
            return;
        }

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] main = new boolean[2 * n - 1];
        boolean[] anti = new boolean[2 * n - 1];

        solve(0, n, board, col, main, anti, ans);
        return ans;
    }

    private void solve(
            int r,
            int n,
            char[][] board,
            boolean[] col,
            boolean[] main,
            boolean[] anti,
            List<List<String>> ans) {
        if (r == n) {
            List<String> layout = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                layout.add(new String(board[i]));
            }
            ans.add(layout);
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = r - c + n - 1;
            int d2 = r + c;

            if (col[c] || main[d1] || anti[d2]) {
                continue;
            }

            board[r][c] = 'Q';
            col[c] = true;
            main[d1] = true;
            anti[d2] = true;

            solve(r + 1, n, board, col, main, anti, ans);

            board[r][c] = '.';
            col[c] = false;
            main[d1] = false;
            anti[d2] = false;
        }
    }
}