



import java.util.*;
public class CountRoom {

	
	public static void dfs(char[][] grid,int i,int j,boolean[][] visited,int n, int m) {
		
		if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == '#' || visited[i][j]) return;
		
		visited[i][j] = true;
		dfs(grid,i+1,j,visited,n,m);
		dfs(grid,i-1,j,visited,n,m);
		dfs(grid,i,j+1,visited,n,m);
		dfs(grid,i,j-1,visited,n,m);
	}
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt() , m = scn.nextInt();
		
		scn.nextLine(); // Consume the newline character

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; ++i) {
            String row = scn.nextLine();
            for (int j = 0; j < m; ++j) {
                grid[i][j] = row.charAt(j);
            }
        }
        
        boolean[][] visited = new boolean[1011][1011];
        
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0 ; i<n ; ++i) {
        	for(int j=0 ; j<m ; ++j) {
        		if (grid[i][j] == '.' && !visited[i][j]) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});

                    while (!stack.isEmpty()) {
                        int[] curr = stack.pop();
                        int x = curr[0];
                        int y = curr[1];

                        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '#' || visited[x][y])
                            continue;

                        visited[x][y] = true;

                        for (int[] dir : directions) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            stack.push(new int[]{newX, newY});
                        }
                    }
                    count++;

        	  }
        }
        
//        System.out.println(count);


	
	}
        System.out.println(count);

}
	}
