package ua.java.impls.sudoku;

public class Sudoku
{
	private int[][] grid = new int[9][9];

	public Sudoku(int[][] grid)
	{
		this.grid = grid;
	}

	public boolean solveBox()
	{
		boolean isDone = true;
		int row = 0;
		int column = 0;
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (grid[i][j] == 0)
				{
					row = i;
					column = j;

					isDone = false;
					break;
				}
			}
			if (!isDone)
			{
				break;
			}
		}
		if (isDone)
			return true;
		for (int variant = 1; variant <= 9; variant++)
		{
			if (isAvailible(grid, row, column, variant))
			{
				grid[row][column] = variant;
				if (solveBox())
				{
					return true;
				} else
				{
					grid[row][column] = 0;
				}
			}
		}
		return false;

	}

	private boolean isAvailible(int[][] box, int row, int col, int num)
	{
		// check row and column
		for (int r = 0; r < 9; r++)
		{
			if (box[r][col] == num || box[row][r] == num)
				return false;
		}
		int startRowOfTheSBox = row - row % 3;
		int startColumnofTheBox = col - col % 3;
		for (int i = startRowOfTheSBox; i < startRowOfTheSBox + 3; i++)
		{
			for (int j = startColumnofTheBox; j < startColumnofTheBox + 3; j++)
			{
				if (box[i][j] == num)
					return false;
			}
		}

		return true;
	}

	public int[][] showBox()
	{
		return grid;
	}
}
