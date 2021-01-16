import java.util.*;
import java.lang.*;
import java.io.*;
public class PathExist
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution
{
    public static boolean is_Possible(int[][] grid)
    {
        boolean[][] visited = new boolean[grid.length][grid.length];
        if (grid == null || grid.length == 0) {
            return false;
        }
        int sourceX = 0;
        int sourceY = 0; 
        int destinationX = 0;
        int destinationY = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sourceX = i;
                    sourceY = j;
                } else if (grid[i][j] == 2) {
                    destinationX = i;
                    destinationY = j;
                }
            }
        }
        dfs(grid, sourceX, sourceY, visited, grid.length);
        return visited[destinationX][destinationY];
    }
    public static void dfs(int[][] grid,int currX,int currY, boolean[][] visited, int length) {
        if (currX >= length || currX < 0 || currY >= length || currY < 0 || visited[currX][currY] == true || grid[currX][currY] == 0 )         {
            return;
        }
        visited[currX][currY] = true;
        dfs(grid, currX + 1, currY, visited, length);
        dfs(grid, currX - 1, currY, visited, length);
        dfs(grid, currX, currY + 1, visited, length);
        dfs(grid, currX, currY - 1, visited, length);
    }
}
