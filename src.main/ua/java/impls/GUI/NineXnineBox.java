package ua.java.impls.GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class NineXnineBox extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NineXnineBox()
	{
		this.setBackground(Color.GRAY);
		this.setLayout(new GridLayout(3, 3, 5, 5));
	}
}
