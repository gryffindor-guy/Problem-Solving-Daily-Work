import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.dfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    
    public static ArrayList<Integer> getDFS(int source, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> result, boolean[] visited) {
        visited[source]=true;
		result.add(source);
		for(Integer neighbour: adjList.get(source)){
			if(!visited[neighbour])
				getDFS(neighbour, adjList, result, visited);
		}   
		return null;
    }
    public static ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adjList){
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[v];
	    getDFS(0, adjList, result, visited);
		return result;
	}
}