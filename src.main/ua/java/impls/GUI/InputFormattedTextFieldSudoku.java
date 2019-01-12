package ua.java.impls.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class InputFormattedTextFieldSudoku extends JFormattedTextField
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputFormattedTextFieldSudoku()
	{
		MaskFormatter mask = null;
		try
		{
			mask = new MaskFormatter("#");
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		this.setFormatter(mask);
		this.setFont(new Font("Ravie", Font.PLAIN, 20));
		this.setBackground(Color.LIGHT_GRAY);
		this.setText("0");
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setColumns(5);

	}

}
