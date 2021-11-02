package DFS;/*
    Problem Breakdown  - Travel from Destination 1 to Destination 2, the path will contain obstacles marked as -1 and walkable paths as 0

    Requirements       - Find the number of paths from Dest 1 to Dest 2 also you should cover all the paths

    Solution Breakdown - We will first try to apply DFS to check if we can reach our destionation
    
                        DFS(x, y, grid)
                        {
                            if(!isValid(x, y) && grid[x][y] is not possible to be visited)
                                return
                            DFS(to possible paths)    
                        }
                        
                        - Now how can we find the number of paths
                        
                        - Count all the walkable paths
                        DFS(x, y, grid, paths)
                        {
                            if(!isValid(x, y) && grid[x][y] is not possible to be visited)
                                return
                                
                            if(x, y => destination && remaining steps to dest  = 1) 
                            {
                                    path++;
                                    return;
                            }
                            
                            DFS(to possible paths)    
                        }
 
*/

class Unique_Paths_3 {

	int rowLen = 0;

	int columnLen = 0;

	int no_of_ways = 0;

	int[][] grid;

	//Helper to check valid cell
	public boolean isValid(int x, int y)
	{
		return (x < rowLen && y < columnLen && x >= 0 && y >= 0);
	}

	public int uniquePathsIII(int[][] grid) {

		this.grid = grid;

		rowLen = grid.length;

		columnLen = grid[0].length;

		int steps =  1;

		int start = 0, end = 0;

		//Count the steps to reach dest
		for(int i = 0; i < rowLen; i++)
		{
			for(int j = 0; j < columnLen; j++)
			{
				if(grid[i][j] == 0)
				{
					steps++;
				}
				else if(grid[i][j] == 1)
				{
					start =i;
					end = j;
				}
			}
		}

		DFS(start, end, steps);

		return no_of_ways;
	}

	public void DFS(int x, int y, int steps)
	{
		if(!isValid(x, y) || grid[x][y] == -1)
			return;

		if(grid[x][y] == 2)
		{
			if(steps == 0)
			{
				no_of_ways++;
			}
			return;
		}

		grid[x][y] = -1;

		steps = steps - 1;

		DFS(x+1, y, steps);
		DFS(x-1, y, steps);
		DFS(x, y+1, steps);
		DFS(x, y-1, steps);

		grid[x][y] = 0;

		steps = steps + 1;
	}
}