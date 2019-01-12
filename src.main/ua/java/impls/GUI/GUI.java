package ua.java.impls.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.java.impls.sudoku.GenerateSudokuBoard;
import ua.java.impls.sudoku.Sudoku;

public class GUI
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	JFormattedTextField[][] inputTextFields = new JFormattedTextField[9][9];
	JPanel[][] smallBoxes = new JPanel[3][3];

	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Sudoku Game");
		frame.getContentPane().setBackground(Color.DARK_GRAY);

		JPanel bigBox = new JPanel();
		bigBox.setBackground(Color.DARK_GRAY);
		bigBox.setToolTipText("");
		frame.getContentPane().add(bigBox, BorderLayout.CENTER);
		bigBox.setLayout(new GridLayout(3, 3, 10, 10));

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				smallBoxes[i][j] = new NineXnineBox();
				if (((i == 0 || i == 2) && (j == 0 || j == 2)) || (i == 1 && j == 1))
				{
					smallBoxes[i][j].setBackground(new Color(14, 51, 61));
				}
				bigBox.add(smallBoxes[i][j]);
			}
		}

		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				inputTextFields[i][j] = new InputFormattedTextFieldSudoku();
				if (i < 3)
				{
					if (j < 3)
					{
						smallBoxes[0][0].add(inputTextFields[i][j]);
					} else if (j > 5)
					{
						smallBoxes[0][2].add(inputTextFields[i][j]);
					} else
					{
						smallBoxes[0][1].add(inputTextFields[i][j]);

					}

				} else if (i > 5)
				{
					if (j < 3)
					{
						smallBoxes[2][0].add(inputTextFields[i][j]);
					} else if (j > 5)
					{
						smallBoxes[2][2].add(inputTextFields[i][j]);
					} else
					{
						smallBoxes[2][1].add(inputTextFields[i][j]);

					}
				} else
				{
					if (j < 3)
					{
						smallBoxes[1][0].add(inputTextFields[i][j]);
					} else if (j > 5)
					{
						smallBoxes[1][2].add(inputTextFields[i][j]);
					} else
					{
						smallBoxes[1][1].add(inputTextFields[i][j]);

					}
				}
			}
		}

		JPanel buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton btnSolve = new JButton("Solve");

		btnSolve.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Sudoku sudokuBox = new Sudoku(getFieldsContent());
				sudokuBox.solveBox();
				setFieldsContent(sudokuBox.showBox());
			}
		});

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GenerateSudokuBoard randomboard = new GenerateSudokuBoard(9, 50);
				setFieldsContent(randomboard.fillValues());
			}
		});
		buttonPanel.add(btnGenerate);

		buttonPanel.add(btnSolve);
		frame.setBounds(100, 100, 500, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public int[][] getFieldsContent()
	{
		int[][] fields = new int[9][9];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				fields[i][j] = Integer.parseInt(inputTextFields[i][j].getText());
			}
		}
		return fields;
	}

	public void setFieldsContent(int[][] pattern)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				inputTextFields[i][j].setText("" + pattern[i][j]);
			}
		}
	}
}
