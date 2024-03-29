//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] mstMember = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstMember[i] = false;
        }
        
        key[0] = 0;
        parent[0] = -1;
        
        for(int i = 0; i < V-1; i++) {
            
            int minimum = Integer.MAX_VALUE;
            int vertex = 0;
            for(int curr = 0; curr < V; curr++) {
                if(mstMember[curr] == false && key[curr] < minimum) {
                    minimum = key[curr];
                    vertex = curr;
                }
            }
            
            for(ArrayList node : adj.get(curr)) {
                if(mstMember[node.get(0)] == false && node.get(1) < key[node.get(0)]) {
                    key[node.get(0)] = node.get(1);
                    parent[node.get(0)] = curr;
                }
            }
        }
    }
}
