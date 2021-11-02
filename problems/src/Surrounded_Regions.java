import java.util.LinkedList;
import java.util.List;

class Surrounded_Regions {
    
    /* Problem breakdown 
                    - O Cells which are in border and the O cells chained to it will not be affected
                    - O Cells which are surrounded by X cells in all directions will be affected
       Requirement
                    - Mark the affects cells as O or X after checking the above conditions
        
       Solution breakdown
                    - Since border cells are not affected, start from the border cells and check the conditions.
                    - DFS or BFS, Why? We have to mark the cells in border and its chain to 0. So DFS or BFS
    */

	/* Better to use a single object for two values x and y positions */
	class Position
	{
		int x, y;

		Position(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	int rowLen, columnLen; // Row and Column Len



	/* Helper function to check the valid cell position */
	public boolean isValid(int x, int y)
	{
		return (x >= 0 && y>=0 && x<rowLen && y <columnLen);
	}


	public void solve(char[][] board) {

		if(board == null || board.length == 0)
			return;

		rowLen = board.length;

		columnLen = board[0].length;


		List<Position> borderCells = new LinkedList<>();

		//Gather the border cells first

		for(int i = 0; i < rowLen; i++)
		{
			borderCells.add(new Position(i, 0));
			borderCells.add(new Position(i, columnLen - 1));
		}

		for(int j = 0; j < columnLen; j++)
		{
			borderCells.add(new Position(0, j));
			borderCells.add(new Position(rowLen - 1, j));
		}

		//DFS
		for(Position point: borderCells)
		{
			DFS(board, point.x, point.y);
		}

		for(int x = 0; x < rowLen; x++)
		{
			for(int y = 0; y < columnLen; y++)
			{
				if(board[x][y] == 'O')
					board[x][y] = 'X';
				else if(board[x][y] == 'E')
					board[x][y] = 'O';
			}
		}
	}

	public void DFS(char[][] board, int x, int y)
	{
		if(!isValid(x, y) || board[x][y] != 'O')
			return;

		board[x][y] = 'E';

		DFS(board, x+1, y);
		DFS(board, x-1, y);
		DFS(board, x, y+1);
		DFS(board, x, y-1);
	}
}