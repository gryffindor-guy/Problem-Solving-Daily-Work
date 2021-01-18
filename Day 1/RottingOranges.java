class RottingOranges {
    
    static class Position {
        int x;
        int y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int rotten = 0, total = 0, minutes = 0;
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                    if (grid[i][j] == 2) {
                        queue.offer(new Position(i, j));
                    }
                }
            }
        }
        if(total == 0) {
            return 0;
        }
        while(!queue.isEmpty() && rotten < total) {
            int currSize = queue.size();
            rotten += currSize;
            if (rotten == total) {
                return minutes;
            }
            minutes++;
            for (int i = 0; i < currSize;i++) {
                Position currNode = queue.poll();
                
                if (currNode.x+1 < grid.length && grid[currNode.x+1][currNode.y] == 1) {
                    grid[currNode.x+1][currNode.y] = 2;
                    queue.offer(new Position(currNode.x+1, currNode.y));
                }
                if (currNode.y+1 < grid[0].length && grid[currNode.x][currNode.y+1] == 1) {
                    grid[currNode.x][currNode.y+1] = 2;
                    queue.offer(new Position(currNode.x, currNode.y+1));
                }
                if (currNode.x-1 >= 0 && grid[currNode.x-1][currNode.y] == 1) {
                    grid[currNode.x-1][currNode.y] = 2;
                    queue.offer(new Position(currNode.x-1, currNode.y));
                }
                if (currNode.y-1 >= 0 && grid[currNode.x][currNode.y-1] == 1) {
                    grid[currNode.x][currNode.y-1] = 2;
                    queue.offer(new Position(currNode.x, currNode.y-1));
                }
            }
        }
        return -1;
    }
}public class RottenOranges {
    
}
