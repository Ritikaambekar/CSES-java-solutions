

import java.util.*;
public class Labyrith2 {
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt() , m = scn.nextInt();
		scn.nextLine(); // Consume the newline character
		
		boolean[][] vis = new boolean[n][m];
		char[][] path = new char[n][m];
		int[][] dis = new int[n][m];
		int[][] grid = new int[n][m];
		
		// made grid
		for(int i=0 ; i<n ; i++) {
			String row = scn.next();
			for(int j=0 ; j<m ; j++) {
				grid[i][j] = row.charAt(j);
				
			}
		}
		
		//find the start and end cords
		
		int sx = 0 , sy = 0 , ex = 0 ,ey = 0;
		for(int i=0 ; i<n ;i++) {
			for(int j=0 ; j<m ; j++) {
				
				if(grid[i][j] == 'A') {
					sx = i ; sy = j;
				}else if(grid[i][j] == 'B') {
					ex = i ; ey = j;
				}else {
					continue;
				}
			}
		}
		
		// make a queue and add the start cords
		
	
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx,sy});
		
		
		// traverse the grid
		
		int[][] dirt = {{-1,0},{1,0},{0,-1},{0,1}}; // u d l r
		
		
		while(!q.isEmpty()) {
			
			int[] t = q.remove();
			int r = t[0] , c = t[1];
			if(r == ex && c == ey) break;
			
			for(int i=0 ; i<4 ; i++) {
				
				int nr = r + dirt[i][0] , nc = c + dirt[i][1];
				
				if(nr>=n || nc >=m || nr<0 || nc <0 || vis[nr][nc] || grid[nr][nc] == '#') continue;
				
				if(i == 0) {
					path[nr][nc] = 'U';
				}else if(i == 1) {
					path[nr][nc] = 'D';
				}else if(i == 2) {
					path[nr][nc] = 'L';
				}else if(i == 3) {
					path[nr][nc] = 'R';
				}
				
				vis[nr][nc] = true;
				q.offer(new int[] {nr,nc});
				dis[nr][nc] = 1 + dis[r][c];
				
				
			}
			
			
		}
	
		
		if(!vis[ex][ey]) {
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		System.out.println(dis[ex][ey]);
//		String res = "";
		StringBuilder res = new StringBuilder();
		
		Queue<int[]> b = new LinkedList<>();
		b.offer(new int[]{ex,ey});
		
		
		while(!b.isEmpty()) {
			int[] r = b.remove();
			
			if(r[0] == sx && r[1] == sy) break;
			if(path[r[0]][r[1]] == 'U') {
//				res +="U";
				res.append("U");
				b.offer(new int[]{r[0]+1,r[1]});
			}else if(path[r[0]][r[1]] == 'D') {
//				res +="D";
				res.append("D");
				b.offer(new int[]{r[0]-1,r[1]});
			}else if(path[r[0]][r[1]] == 'L') {
//				res +="L";
				res.append("L");
				b.offer(new int[]{r[0],r[1]+1});
			}else if(path[r[0]][r[1]] == 'R') {
//				res +="R";
				res.append("R");
				b.offer(new int[]{r[0],r[1]-1});
			}
			
		}
		
		System.out.println(res.reverse());

		
//		for(int i=0 ;i<n ;i++) {
//			for(int j=0 ;j<m ;j++) {
//				System.out.print(path[i][j]);
//			}
//			System.out.println();
//		}
		
		
		
		
		
		
		
	}
	

	
}
	
	 


