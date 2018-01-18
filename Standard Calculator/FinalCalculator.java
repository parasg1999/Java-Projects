import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FinalCalculator implements ActionListener
{
	int decimalCount = 0, i, afterDecimal;
	double liveNumber1 = 0, liveNumber2 = 0;
	String numberString = "0", resultString = "0", historyString = " ", lastButtonPressed = "", decimalNumber;
	GridBagLayout gridBagLayout;	
	GridBagConstraints gridBagConstraints;
	JFrame frame;
	JPanel mainPanel, displayPanel;
	JLabel numberLabel, historyLabel;
	JButton addButton, subtractButton, multiplyButton, divideButton, signChangeButton, equalButton, decimalPointButton, numberOneButton, numberTwoButton, numberThreeButton, numberFourButton, numberFiveButton, numberSixButton, numberSevenButton, numberEightButton, numberNineButton, numberZeroButton, backspaceButton, cButton, ceButton, sqrtButton, squareButton, cubeButton, invertButton, percentageButton;
	Color myColor = new Color(244, 244, 244);
	String lastOperator = "";
	Font numberButtonFont = new Font("Arial", Font.BOLD, 20), operatorButtonFont = new Font("Arial", Font.PLAIN, 20);
	public FinalCalculator() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		frame = new JFrame("Calculator");

		mainPanel = new JPanel();
		displayPanel = new JPanel();
		
		historyLabel = new JLabel(historyString);
		historyLabel.setFont(new Font("Ariel", Font.BOLD, 15));
		historyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numberLabel = new JLabel(numberString);
		numberLabel.setFont(new Font("Ariel", Font.BOLD, 35));
		numberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numberLabel.setMaximumSize(new Dimension(20, 20));
		numberLabel.setMinimumSize(new Dimension(20, 20));
//		displayPanel.setLayout(new BorderLayout());
//		displayPanel.add(historyLabel, BorderLayout.NORTH);
//		displayPanel.add(numberLabel, BorderLayout.CENTER);
		
		addButton = new JButton("+");
		addButton.setFont(operatorButtonFont);
		addButton.setBackground(myColor);
		addButton.setBorder(null);
		addButton.addActionListener(this);
		subtractButton = new JButton("-");
		subtractButton.setFont(operatorButtonFont);
		subtractButton.setBackground(myColor);
		subtractButton.setBorder(null);
		subtractButton.addActionListener(this);
		divideButton = new JButton("÷");
		divideButton.setFont(operatorButtonFont);
		divideButton.setBackground(myColor);
		divideButton.setBorder(null);
		divideButton.addActionListener(this);
		multiplyButton = new JButton("×");
		multiplyButton.setFont(operatorButtonFont);
		multiplyButton.setBackground(myColor);
		multiplyButton.setBorder(null);
		multiplyButton.addActionListener(this);
		signChangeButton = new JButton("±");
		signChangeButton.setFont(operatorButtonFont);
		signChangeButton.setBackground(myColor);
		signChangeButton.setBorder(null);
		signChangeButton.addActionListener(this);
		equalButton = new JButton("=");
		equalButton.setFont(operatorButtonFont);
		equalButton.setBackground(myColor);
		equalButton.setBorder(null);
		equalButton.addActionListener(this);
		
		decimalPointButton = new JButton(".");
		decimalPointButton.setBackground(Color.WHITE);
		decimalPointButton.setFont(numberButtonFont);
		decimalPointButton.addActionListener(this);
		decimalPointButton.setBorder(null);
				
		numberOneButton = new JButton("1");
		numberOneButton.setBackground(Color.WHITE);
		numberOneButton.setFont(numberButtonFont);
		numberOneButton.addActionListener(this);
		numberOneButton.setBorder(null);
		numberTwoButton = new JButton("2");
		numberTwoButton.setBackground(Color.WHITE);
		numberTwoButton.setFont(numberButtonFont);
		numberTwoButton.addActionListener(this);
		numberTwoButton.setBorder(null);
		numberThreeButton = new JButton("3");
		numberThreeButton.setBackground(Color.WHITE);
		numberThreeButton.setFont(numberButtonFont);
		numberThreeButton.addActionListener(this);
		numberThreeButton.setBorder(null);
		numberFourButton = new JButton("4");
		numberFourButton.setBackground(Color.WHITE);
		numberFourButton.setFont(numberButtonFont);
		numberFourButton.addActionListener(this);
		numberFourButton.setBorder(null);
		numberFiveButton = new JButton("5");
		numberFiveButton.setBackground(Color.WHITE);
		numberFiveButton.setFont(numberButtonFont);
		numberFiveButton.addActionListener(this);
		numberFiveButton.setBorder(null);
		numberSixButton = new JButton("6");
		numberSixButton.setBackground(Color.WHITE);
		numberSixButton.setFont(numberButtonFont);
		numberSixButton.addActionListener(this);
		numberSixButton.setBorder(null);
		numberSevenButton = new JButton("7");
		numberSevenButton.setBackground(Color.WHITE);
		numberSevenButton.setFont(numberButtonFont);
		numberSevenButton.addActionListener(this);
		numberSevenButton.setBorder(null);
		numberEightButton = new JButton("8");
		numberEightButton.setBackground(Color.WHITE);
		numberEightButton.setFont(numberButtonFont);
		numberEightButton.addActionListener(this);
		numberEightButton.setBorder(null);
		numberNineButton = new JButton("9");
		numberNineButton.setBackground(Color.WHITE);
		numberNineButton.setFont(numberButtonFont);
		numberNineButton.addActionListener(this);
		numberNineButton.setBorder(null);
		numberZeroButton = new JButton("0");
		numberZeroButton.setBackground(Color.WHITE);
		numberZeroButton.setFont(numberButtonFont);
		numberZeroButton.addActionListener(this);
		numberZeroButton.setBorder(null);
		
		backspaceButton = new JButton("Del");
		backspaceButton.setBackground(myColor);
		backspaceButton.setFont(operatorButtonFont);
		backspaceButton.addActionListener(this);
		backspaceButton.setBorder(null);
		cButton = new JButton("C");
		cButton.setBackground(myColor);
		cButton.setFont(operatorButtonFont);
		cButton.addActionListener(this);
		cButton.setBorder(null);
		ceButton = new JButton("CE");
		ceButton.setBackground(myColor);
		ceButton.setFont(operatorButtonFont);
		ceButton.addActionListener(this);
		ceButton.setBorder(null);
		sqrtButton = new JButton("√x");
		sqrtButton.setBackground(myColor);
		sqrtButton.setFont(new Font("Arial", Font.ITALIC, 20));
		sqrtButton.addActionListener(this);
		sqrtButton.setBorder(null);
		squareButton = new JButton("x²");
		squareButton.setBackground(myColor);
		squareButton.setFont(new Font("Arial", Font.ITALIC, 20));
		squareButton.addActionListener(this);
		squareButton.setBorder(null);
		cubeButton = new JButton("x³");
		cubeButton.setBackground(myColor);
		cubeButton.setFont(new Font("Arial", Font.ITALIC, 20));
		cubeButton.addActionListener(this);
		cubeButton.setBorder(null);
		invertButton = new JButton("¹/x ");
		invertButton.setBackground(myColor);
		invertButton.setFont(new Font("Arial", Font.ITALIC, 20));
		invertButton.addActionListener(this);
		invertButton.setBorder(null);
		percentageButton = new JButton("%");
		percentageButton.setBackground(myColor);
		percentageButton.setFont(operatorButtonFont);
		percentageButton.addActionListener(this);
		percentageButton.setBorder(null);
		
		mainPanel.setLayout(gridBagLayout);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(1, 2, 1, 1);
		mainPanel.add(historyLabel, gridBagConstraints);
		
		gridBagConstraints.gridy = 1;
		mainPanel.add(numberLabel, gridBagConstraints);
		
		gridBagConstraints.insets = new Insets(1, 1, 1, 1);
		
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		mainPanel.add(percentageButton, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		mainPanel.add(sqrtButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		mainPanel.add(squareButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		mainPanel.add(invertButton, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		mainPanel.add(ceButton, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		mainPanel.add(cButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		mainPanel.add(backspaceButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		mainPanel.add(divideButton, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		mainPanel.add(numberSevenButton, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		mainPanel.add(numberEightButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		mainPanel.add(numberNineButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		mainPanel.add(multiplyButton, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		mainPanel.add(numberFourButton, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		mainPanel.add(numberFiveButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		mainPanel.add(numberSixButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		mainPanel.add(subtractButton, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		mainPanel.add(numberOneButton, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		mainPanel.add(numberTwoButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		mainPanel.add(numberThreeButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		mainPanel.add(addButton, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		mainPanel.add(signChangeButton, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		mainPanel.add(numberZeroButton, gridBagConstraints);
		gridBagConstraints.gridx = 2;
		mainPanel.add(decimalPointButton, gridBagConstraints);
		gridBagConstraints.gridx = 3;
		mainPanel.add(equalButton, gridBagConstraints);
		
//		displayPanel.setBackground(new Color(230, 230, 230));
//		displayPanel.setBorder(new EmptyBorder(5,0,2,4));
		mainPanel.setBackground(new Color(230, 230, 230));
		mainPanel.setBorder(new EmptyBorder(2,2,1,2));
		
		frame.setAlwaysOnTop(true);
		frame.add(mainPanel);
		frame.setSize(335,410);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new FinalCalculator();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		liveNumber2 = Double.parseDouble(numberLabel.getText());
		if(lastOperator == "")
		{
			resultString = numberLabel.getText();
		}
		if(event.getSource() == addButton || event.getSource() == subtractButton || event.getSource() == multiplyButton || event.getSource() == divideButton || event.getSource() == equalButton)
		{
			if(lastOperator == "+")
			{
				resultString = Double.toString(Double.parseDouble(resultString) + Double.parseDouble(numberLabel.getText()));
			}
			if(lastOperator == "-")
			{
				resultString = Double.toString(Double.parseDouble(resultString) - Double.parseDouble(numberLabel.getText()));
			}
			if(lastOperator == "*")
			{
				resultString = Double.toString(Double.parseDouble(resultString) * Double.parseDouble(numberLabel.getText()));
			}
			if(lastOperator == "/")
			{
				resultString = Double.toString(Double.parseDouble(resultString) / Double.parseDouble(numberLabel.getText()));
			}
		}	
		if(numberString == "Infinity")
		{
			numberString = "0";
		}
		if(event.getSource() == decimalPointButton)
		{
			lastButtonPressed = ".";
			if(numberString.contains("."))
			{	}
			else
			{
				numberString += ".";
				decimalNumber = numberString;
			}
		}
		else if(event.getSource() == numberZeroButton)
		{
			if(Double.parseDouble(numberString) == 0 )
			{
				if(lastButtonPressed == "." || lastButtonPressed == "0")
				{
					
				}
				else
				{
					numberString = "0";
				}
			}
			else
			{
				numberString += "0";
			}
			lastButtonPressed = "0";
		}
		else if(event.getSource() == numberOneButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.1";
				}
				else
				{
				numberString = "1";
				}
			}
			else
			{
				numberString += "1";
			}
			lastButtonPressed = "1";
		}
		else if(event.getSource() == numberTwoButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.2";
				}
				else
				{
					numberString = "2";
				}
			}
			else
			{
				numberString += "2";
			}
			lastButtonPressed = "2";
		}
		else if(event.getSource() == numberThreeButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.3";
				}
				else
				{
					numberString = "3";
				}
			}
			else
			{
				numberString += "3";
			}
			lastButtonPressed = "3";
		}
		else if(event.getSource() == numberFourButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.4";
				}
				else
				{
					numberString = "4";
				}
			}
			else
			{
				numberString += "4";
			}
			lastButtonPressed = "4";
		}
		else if(event.getSource() == numberFiveButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.5";
				}
				else
				{
				numberString = "5";
				}
			}
			else
			{
				numberString += "5";
			}
			lastButtonPressed = "5";
		}
		else if(event.getSource() == numberSixButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.6";
				}
				else
				{
					numberString = "6";
				}
			}
			else
			{
				numberString += "6";
			}
			lastButtonPressed = "6";
		}
		else if(event.getSource() == numberSevenButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.7";
				}
				else
				{
					numberString = "7";
				}
			}
			else 
			{
				numberString += "7";
			}
			lastButtonPressed = "7";
		}
		else if(event.getSource() == numberEightButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.8";
				}
				else
				{
					numberString = "8";
				}
			}
			else
			{
				numberString += "8";
			}
			lastButtonPressed = "8";
		}
		else if(event.getSource() == numberNineButton)
		{
			if(Double.parseDouble(numberString) == 0)
			{
				if(lastButtonPressed == ".")
				{
					numberString = "0.9";
				}
				else
				{
					numberString = "9";
				}
			}
			else
			{
				numberString += "9";
			}
			lastButtonPressed = "9";
		}
		else if(event.getSource() == signChangeButton)
		{
			lastButtonPressed = "+-";
			liveNumber1 = Double.parseDouble(numberLabel.getText());
			liveNumber1 = liveNumber1 * (-1);
			numberString = Double.toString(liveNumber1);
		}
		else if(event.getSource() == backspaceButton)
		{
			lastButtonPressed = "del";
			int p = 0;
			if(numberString.contains("-"))
			{
				if(numberString.length() == 2)
				{
					numberString = "0";
				}
				else
				{
				p = 1;
				numberString = numberString.substring(1, numberString.length());
				}
			}
			if(numberString.length() > 1)
			{
//				if(numberString.charAt(numberString.length()-1) == '.')
//				{
//					decimalCount = 0;
//				}
					numberString = numberString.substring(0, numberString.length()-1);
					if(p == 1)
					{
						numberString = "-" + numberString;
					}
				}
			else
			{
				numberString = "0";
			}
		}
		else if(event.getSource() == cButton)
		{
			lastButtonPressed = "c";
			numberString = "0";
			historyString = " ";
			resultString = "0";
			liveNumber1 = liveNumber2 = 0;
			historyLabel.setText(historyString);
		}
		else if(event.getSource() == ceButton)
		{
			lastButtonPressed = "ce";
			numberString = "0";
		}
		else if(event.getSource() == squareButton)
		{
			lastButtonPressed = "square";
			liveNumber1 = Double.parseDouble(resultString);
			liveNumber1 *= liveNumber1;
			numberString = Double.toString(liveNumber1);
		}
		else if(event.getSource() == sqrtButton)
		{
			lastButtonPressed = "sqrt";
			if(numberString == "")
			{
				numberString = "0";
			}
			liveNumber1 = Double.parseDouble(resultString);
			liveNumber1 = Math.sqrt(liveNumber1);
			numberString = Double.toString(liveNumber1);
		}
		else if(event.getSource() == invertButton)
		{
			lastButtonPressed = "invert";
			if(numberString == "")
			{
				numberString = "0";
			}
			liveNumber1 = Double.parseDouble(resultString);
			liveNumber1 = 1 / liveNumber1;
			numberString = Double.toString(liveNumber1);
		}
		
		if(Double.parseDouble(numberString) != 0)
		{
			if(Math.floor(Double.parseDouble(numberString)) == Math.ceil(Double.parseDouble(numberString))) 
			{
				int i = (int) Double.parseDouble(numberString);
				numberLabel.setText(i+"");
			}
			numberLabel.setText(numberString.substring(0, numberString.length()));
		}
		else if(numberString.contains("."))
		{
			numberLabel.setText(numberString);
		}
		else
		{
			numberString = "0";
			numberLabel.setText(numberString);
		}
		
		if(event.getSource() == addButton)
		{
			lastButtonPressed = "+";
			historyString += liveNumber2 + " + ";
			historyLabel.setText(historyString);
//			liveNumber2 = Double.parseDouble(numberLabel.getText());
			numberString = "0";
			lastOperator = "+";
			numberLabel.setText(resultString);
		}
		else if(event.getSource() == subtractButton)
		{
			lastButtonPressed = "-";
			historyString += liveNumber2 + " - ";
			historyLabel.setText(historyString);
			liveNumber2 = Double.parseDouble(numberLabel.getText());
			numberString = "0";
			lastOperator = "-";
			numberLabel.setText(resultString);
		}
		else if(event.getSource() == multiplyButton)
		{
			lastButtonPressed = "*";	
			historyString += liveNumber2 + " × ";
			historyLabel.setText(historyString);
			liveNumber2 = Double.parseDouble(numberLabel.getText());
			numberString = "0";
			lastOperator = "*";
			numberLabel.setText(resultString);
		}
		else if(event.getSource() == divideButton)
		{
			lastButtonPressed = "/";
			historyString += liveNumber2 + " ÷ ";
			historyLabel.setText(historyString);
			liveNumber2 = Double.parseDouble(numberLabel.getText());
			numberString = "0";
			lastOperator = "/";
			numberLabel.setText(resultString);
		}
		else if(event.getSource() == percentageButton)
		{
			lastButtonPressed = "%";
			liveNumber2 = (liveNumber2 / 100) * Double.parseDouble(resultString);
			numberLabel.setText(Double.toString(liveNumber2));		
		}
		if(event.getSource() == equalButton)
		{
			lastButtonPressed = "=";
			lastOperator = "";
			historyString = " ";
			historyLabel.setText(historyString);
			numberLabel.setText(resultString);
			numberString = "0";
		//	resultString = "0";
		}
		if(lastButtonPressed == "+" || lastButtonPressed == "-" || lastButtonPressed == "*" || lastButtonPressed == "/")
		{
			addButton.setEnabled(false);
			subtractButton.setEnabled(false);
			multiplyButton.setEnabled(false);
			divideButton.setEnabled(false);
		}
		else
		{
			addButton.setEnabled(true);
			subtractButton.setEnabled(true);
			multiplyButton.setEnabled(true);
			divideButton.setEnabled(true);
		}
		
		if(numberLabel.getText().length() > 18)
		{
			numberLabel.setFont(new Font("Ariel", Font.BOLD, 20));
		}
		else if(numberLabel.getText().length() > 26)
		{
			numberOneButton.setEnabled(false);
			numberTwoButton.setEnabled(false);
			numberThreeButton.setEnabled(false);
			numberFourButton.setEnabled(false);
			numberFiveButton.setEnabled(false);
			numberSixButton.setEnabled(false);
			numberSevenButton.setEnabled(false);
			numberEightButton.setEnabled(false);
			numberNineButton.setEnabled(false);
			numberZeroButton.setEnabled(false);
			decimalPointButton.setEnabled(false);
		}
		else 
		{
			numberOneButton.setEnabled(true);
			numberTwoButton.setEnabled(true);
			numberThreeButton.setEnabled(true);
			numberFourButton.setEnabled(true);
			numberFiveButton.setEnabled(true);
			numberSixButton.setEnabled(true);
			numberSevenButton.setEnabled(true);
			numberEightButton.setEnabled(true);
			numberNineButton.setEnabled(true);
			numberZeroButton.setEnabled(true);
			decimalPointButton.setEnabled(true);
		}
	}

}