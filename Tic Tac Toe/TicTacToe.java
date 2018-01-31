import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener 
{
	
	Point p = new Point(507 , 213);
	JFrame frame;
	JPanel panel;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JLabel turnLabel;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstaints;
	char status[][] = new char[3][3];
	public TicTacToe() {
		gridBagLayout = new GridBagLayout();
		gridBagConstaints = new GridBagConstraints();
		
		frame = new JFrame("Tic Tac Toe");
		
		panel = new JPanel();
		
		b1 = new JButton(" ");
//		b1.setBackground(Color.WHITE);
		b1.addActionListener(this);
		b2 = new JButton(" ");
//		b2.setBackground(Color.CYAN);
		b2.addActionListener(this);
		b3 = new JButton(" ");
//		b3.setBackground(Color.WHITE);
		b3.addActionListener(this);
		b4 = new JButton(" ");
//		b4.setBackground(Color.BLUE);
		b4.addActionListener(this);
		b5 = new JButton(" ");
//		b5.setBackground(Color.WHITE);
		b5.addActionListener(this);
		b6 = new JButton(" ");
//		b6.setBackground(Color.BLUE);
		b6.addActionListener(this);
		b7 = new JButton(" ");
//		b7.setBackground(Color.WHITE);
		b7.addActionListener(this);
		b8 = new JButton(" ");
//		b8.setBackground(Color.BLUE);
		b8.addActionListener(this);
		b9 = new JButton(" ");
//		b9.setBackground(Color.WHITE);
		b9.addActionListener(this);
		
		turnLabel = new JLabel("First Player make your move" , SwingConstants.CENTER);
		turnLabel.requestFocus(true);
		
		panel.setLayout(gridBagLayout);
		
		gridBagConstaints.gridx = 0;
		gridBagConstaints.gridy = 0;
		gridBagConstaints.gridwidth = 3;
		gridBagConstaints.weightx = 1;
		gridBagConstaints.weighty = 1;
		gridBagConstaints.fill = GridBagConstraints.BOTH;
		panel.add(turnLabel , gridBagConstaints);
		gridBagConstaints.gridx = 0;
		gridBagConstaints.gridy = 1;
		gridBagConstaints.gridwidth = 1;
		panel.add(b1 , gridBagConstaints);
		gridBagConstaints.gridx = 1;
		panel.add(b2 , gridBagConstaints);
		gridBagConstaints.gridx = 2;
		panel.add(b3 , gridBagConstaints);
		gridBagConstaints.gridx = 0;
		gridBagConstaints.gridy = 2;
		panel.add(b4 , gridBagConstaints);
		gridBagConstaints.gridx = 1;
		panel.add(b5 , gridBagConstaints);
		gridBagConstaints.gridx = 2;
		panel.add(b6 , gridBagConstaints);
		gridBagConstaints.gridx = 0;
		gridBagConstaints.gridy = 3;
		panel.add(b7 , gridBagConstaints);
		gridBagConstaints.gridx = 1;
		panel.add(b8 , gridBagConstaints);
		gridBagConstaints.gridx = 2;
		panel.add(b9 , gridBagConstaints);
		
		frame.add(panel);
		frame.setLocation(p);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new TicTacToe();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(turnLabel.getText().equals("First Player make your move"))
		{
			if(event.getSource() == b1)
			{
				b1.setText("X");
				b1.setEnabled(false);
			}
			else if(event.getSource() == b2)
			{
				b2.setText("X");
				b2.setEnabled(false);
			}
			else if(event.getSource() == b3)
			{
				b3.setText("X");
				b3.setEnabled(false);
			}
			else if(event.getSource() == b4)
			{
				b4.setText("X");
				b4.setEnabled(false);
			}
			else if(event.getSource() == b5)
			{
				b5.setText("X");
				b5.setEnabled(false);
			}
			else if(event.getSource() == b6)
			{
				b6.setText("X");
				b6.setEnabled(false);
			}
			else if(event.getSource() == b7)
			{
				b7.setText("X");
				b7.setEnabled(false);
			}
			else if(event.getSource() == b8)
			{
				b8.setText("X");
				b8.setEnabled(false);
			}
			else if(event.getSource() == b9)
			{
				b9.setText("X");
				b9.setEnabled(false);
			}
			turnLabel.setText("Second Player make your move");
		}
		else if(turnLabel.getText().equals("Second Player make your move"))
		{
			if(event.getSource() == b1)
			{
				b1.setText("O");
				b1.setEnabled(false);
			}
			else if(event.getSource() == b2)
			{
				b2.setText("O");
				b2.setEnabled(false);
			}
			else if(event.getSource() == b3)
			{
				b3.setText("O");
				b3.setEnabled(false);
			}
			else if(event.getSource() == b4)
			{
				b4.setText("O");
				b4.setEnabled(false);
			}
			else if(event.getSource() == b5)
			{
				b5.setText("O");
				b5.setEnabled(false);
			}
			else if(event.getSource() == b6)
			{
				b6.setText("O");
				b6.setEnabled(false);
			}
			else if(event.getSource() == b7)
			{
				b7.setText("O");
				b7.setEnabled(false);
			}
			else if(event.getSource() == b8)
			{
				b8.setText("O");
				b8.setEnabled(false);
			}
			else if(event.getSource() == b9)
			{
				b9.setText("O");
				b9.setEnabled(false);
			}
			turnLabel.setText("First Player make your move");
		}
		

		status[0][0] = b1.getText().charAt(0);
		status[0][1] = b2.getText().charAt(0);
		status[0][2] = b3.getText().charAt(0);
		status[1][0] = b4.getText().charAt(0);
		status[1][1] = b5.getText().charAt(0);
		status[1][2] = b6.getText().charAt(0);
		status[2][0] = b7.getText().charAt(0);
		status[2][1] = b8.getText().charAt(0);
		status[2][2] = b9.getText().charAt(0);
		
		for(int i = 0 ; i < 3 ; i++)
		{
			if((status[i][0] == status [i][1] && status[i][1] == status[i][2]))
			{
				if(status[i][0] == 'X')
				{
					turnLabel.setText("First Player Wins!!");
					break;
				}
				else if(status[i][0] == 'O')
				{
					turnLabel.setText("Second Player Wins!!");
					break;
				}
			}
		}
		
		for(int i = 0 ; i < 3 ; i++)
		{
			if((status[0][i] == status [1][i] && status[1][i] == status[2][i]))
			{
				if(status[0][i] == 'X')
				{
					turnLabel.setText("First Player Wins!!");
					break;
				}
				else if(status[0][i] == 'O')
				{
					turnLabel.setText("Second Player Wins!!");
					break;
				}
			}
		}
		
		if((status[0][0] == status [1][1] && status[1][1] == status[2][2]) || (status[1][1] == status [0][2] && status[2][0] == status[1][1]))
		{
			if(status[1][1] == 'X')
			{
				turnLabel.setText("First Player Wins!!");
			}
			else if(status[1][1] == 'O')
			{
				turnLabel.setText("Second Player Wins!!");
			}
		}
		
		 if(!b1.isEnabled() && !b2.isEnabled() && !b3.isEnabled() && !b4.isEnabled() && !b5.isEnabled() && !b6.isEnabled() && !b7.isEnabled() && !b8.isEnabled() && !b9.isEnabled() && ( b1.getText() != " " && b2.getText() != " " && b3.getText() != " " && b4.getText() != " " && b5.getText() != " " && b6.getText() != " " && b7.getText() != " " && b8.getText() != " " && b9.getText() != " "))
		 {
			 turnLabel.setText("It's a tie!!");
			 int option = JOptionPane.showConfirmDialog(frame, "Do you want to start a new Game?", turnLabel.getText() , JOptionPane.YES_NO_OPTION);
			 if(option == 0)
				{
					new TicTacToe();
					frame.dispose();
				}
		 }
		
		if(turnLabel.getText().equals("First Player Wins!!") || turnLabel.getText().equals("Second Player Wins!!"))
		{
			int option = JOptionPane.showConfirmDialog(frame, "Do you want to start a new Game?", turnLabel.getText() , JOptionPane.YES_NO_OPTION);
			if(option == 0)
			{
				p = frame.getLocation();
				new TicTacToe();
				frame.dispose();
			}
			else
			{
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				b5.setEnabled(false);
				b6.setEnabled(false);
				b7.setEnabled(false);
				b8.setEnabled(false);
				b9.setEnabled(false);
			}
		}
	}
}