import java.util.*;
import java.lang.*;
import java.io.*;
public class CheckCyclicUndirected
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) 
            visited[i] = false;
        for (int vertex = 0; vertex < V; vertex++) {
            if (!visited[vertex]) {
               if (dfs(adj, visited, -1, vertex)) {
                   return true;
               }
            }
                
        } return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int parent, int vertex) {
        visited[vertex] = true;
        for(int neighbour : adjList.get(vertex)) {
            if(!visited[neighbour]) {
                if(dfs(adjList, visited, vertex, neighbour)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}