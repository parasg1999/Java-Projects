import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class TextEditor implements ActionListener, WindowListener, KeyListener
{
	boolean keyPressed = false;
	String filePath;
	BorderLayout border;
	JFrame frame;
	JPanel mainPanel, statusBarPanel;
	JMenuBar menuBar;
	JMenu fileMenu, editMenu, formatMenu, viewMenu, helpMenu;
	JCheckBoxMenuItem statusBarMenuItem, wordWrapMenuItem;
	JMenuItem newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem, pageSetupMenuItem, printMenuItem, exitMenuItem, undoMenuItem, cutMenuItem, copyMenuItem, pasteMenuItem, deleteMenuItem, findMenuItem, findNextMenuItem, replaceMenuItem, goToMenuItem, selectAllMenuItem, timeDateMenuItem, fontMenuItem, backgroundColorMenuItem, textColorMenuItem, viewHelpMenuItem, aboutTextEditorMenuItem;
	JTextArea editorTextArea;
	JLabel lineAndColumnLabel;
	JScrollPane editorScrollPane;
	
	public TextEditor() {
		border = new BorderLayout();
		
		frame = new JFrame("Untitled - Text Editor");
		
		mainPanel = new JPanel();
		statusBarPanel = new JPanel();
		
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		editMenu = new JMenu("Edit");
		editMenu.setMnemonic('E');
		formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('o');
		viewMenu = new JMenu("View");
		viewMenu.setMnemonic('V');
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		
		newMenuItem = new JMenuItem("New");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newMenuItem.addActionListener(this);
		openMenuItem = new JMenuItem("Open...");
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		openMenuItem.addActionListener(this);
		saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveMenuItem.addActionListener(this);
		saveAsMenuItem = new JMenuItem("Save As...");
		saveAsMenuItem.addActionListener(this);
		pageSetupMenuItem = new JMenuItem("Page Setup...");
		pageSetupMenuItem.setEnabled(false);
		printMenuItem = new JMenuItem("Print...");
		printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		printMenuItem.addActionListener(this);
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		
		undoMenuItem = new JMenuItem("Undo");
		undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		undoMenuItem.addActionListener(this);
		cutMenuItem = new JMenuItem("Cut");
		cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cutMenuItem.addActionListener(this);
		copyMenuItem = new JMenuItem("Copy");
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyMenuItem.addActionListener(this);
		pasteMenuItem = new JMenuItem("Paste");
		pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteMenuItem.addActionListener(this);
		deleteMenuItem = new JMenuItem("Delete");
		deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		deleteMenuItem.addActionListener(this);
		findMenuItem = new JMenuItem("Find...");
		findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		findMenuItem.setEnabled(false);
		findNextMenuItem = new JMenuItem("Find Next");
		findNextMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		findNextMenuItem.setEnabled(false);
		replaceMenuItem = new JMenuItem("Replace...");
		replaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		replaceMenuItem.setEnabled(false);
		goToMenuItem = new JMenuItem("Go To...");
		goToMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		goToMenuItem.setEnabled(false);
		selectAllMenuItem = new JMenuItem("Select All");
		selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		selectAllMenuItem.addActionListener(this);
		timeDateMenuItem = new JMenuItem("Time/Date");
		timeDateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		timeDateMenuItem.addActionListener(this);
		
		wordWrapMenuItem = new JCheckBoxMenuItem("Word Wrap",false);
		wordWrapMenuItem.addActionListener(this);
		fontMenuItem = new JMenuItem("Font...");
		fontMenuItem.addActionListener(this);
		fontMenuItem.setEnabled(false);
		backgroundColorMenuItem = new JMenuItem("Background Color...");
		backgroundColorMenuItem.addActionListener(this);
		textColorMenuItem = new JMenuItem("Text Color...");
		textColorMenuItem.addActionListener(this);
		
		statusBarMenuItem = new JCheckBoxMenuItem("Status Bar",true);
		statusBarMenuItem.addActionListener(this);
		
		viewHelpMenuItem = new JMenuItem("View Help");
		viewHelpMenuItem.setEnabled(false);
		aboutTextEditorMenuItem = new JMenuItem("About Text Editor");
		aboutTextEditorMenuItem.addActionListener(this);
		
		editorTextArea = new JTextArea();
		
		lineAndColumnLabel = new JLabel("Line " + 1 + ", Column "  + 1);
		
		editorScrollPane = new JScrollPane(editorTextArea);

		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(pageSetupMenuItem);
		fileMenu.add(printMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		
		editMenu.add(undoMenuItem);
		editMenu.addSeparator();
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		editMenu.add(deleteMenuItem);
		editMenu.addSeparator();
		editMenu.add(findMenuItem);
		editMenu.add(findNextMenuItem);
		editMenu.add(replaceMenuItem);
		editMenu.add(goToMenuItem);
		editMenu.addSeparator();
		editMenu.add(selectAllMenuItem);
		editMenu.add(timeDateMenuItem);
		
		formatMenu.add(wordWrapMenuItem);
		formatMenu.addSeparator();
		formatMenu.add(fontMenuItem);
		formatMenu.add(backgroundColorMenuItem);
		formatMenu.add(textColorMenuItem);
		
		viewMenu.add(statusBarMenuItem);
		
		helpMenu.add(viewHelpMenuItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutTextEditorMenuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);
		
		statusBarPanel.add(lineAndColumnLabel);
		
		mainPanel.setLayout(border);
		mainPanel.add(editorScrollPane, BorderLayout.CENTER);
		mainPanel.add(statusBarPanel, BorderLayout.SOUTH);
		
		frame.addWindowListener(this);
		frame.add(mainPanel);
		frame.setSize(600,500);
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		
		editorTextArea.addKeyListener(this);
		
		editorTextArea.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent event)
			{
				JTextArea editArea = (JTextArea) event.getSource();
				
				int lineNum = 1, columnNum = 1;
				
				try {
					int caretPosition = editArea.getCaretPosition();
					lineNum = editArea.getLineOfOffset(caretPosition);
					columnNum = caretPosition - editArea.getLineStartOffset(lineNum) + 1;
					lineNum += 1;
				} catch(Exception ex) {}
				
				lineAndColumnLabel.setText("Line " + lineNum + ", Column " + columnNum);
			}
		});
	}
	public static void main(String[] args) {
		new TextEditor();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == newMenuItem)
		{
			new TextEditor();
		}
		else if(event.getSource() == openMenuItem)
		{
			JFileChooser openFile = new JFileChooser();
			int i = openFile.showOpenDialog(editorScrollPane);
			if(i == JFileChooser.APPROVE_OPTION)
			{
				File file = openFile.getSelectedFile();
				filePath = file.getPath();
				 try{  
					 	frame.setTitle(filePath + " - Text Editor");
					 	FileInputStream input = new FileInputStream(filePath);
				        int charReader = 0;
				        String s1 = "", s2 = "";
				        while((charReader = input.read()) != -1)
				        {
				        	s2 += s1 + ((char)charReader);
				        }
				        editorTextArea.setText(s2);
				        input.close();
				        keyPressed = false;
				        }catch (Exception ex) { }
			}
		}
		else if(event.getSource() == saveMenuItem)
		{
			if(frame.getTitle() == "Untitled - Text Editor")
			{
				JFileChooser openFile = new JFileChooser();
				int i = openFile.showSaveDialog(editorScrollPane);
				if(i == JFileChooser.APPROVE_OPTION)
				{
					File file = openFile.getSelectedFile();
					filePath = file.getPath();
					 try{  
						 FileOutputStream output = new FileOutputStream(filePath);
						 String s = editorTextArea.getText();
						 byte b[] = s.getBytes();
						 output.write(b);
						 frame.setTitle(filePath + " - Text Editor");
						 output.close();
					 }catch(Exception ex) { }
				}
			}
			else
			{
				try{
					 filePath = frame.getTitle().substring(0, frame.getTitle().length() - 14);
					 FileOutputStream output = new FileOutputStream(filePath);
					 String s = editorTextArea.getText();
					 byte b[] = s.getBytes();
					 output.write(b);
					 frame.setTitle(filePath + " - Text Editor");
					 output.close();
				 }catch(Exception ex) { }
			}
		}
		else if(event.getSource() == saveAsMenuItem)
		{
			JFileChooser openFile = new JFileChooser();
			int i = openFile.showSaveDialog(editorScrollPane);
			if(i == JFileChooser.APPROVE_OPTION)
			{
				File file = openFile.getSelectedFile();
				filePath = file.getPath();
				 try{  
					 FileOutputStream output = new FileOutputStream(filePath);
					 String s = editorTextArea.getText();
					 byte b[] = s.getBytes();
					 output.write(b);
					 frame.setTitle(filePath  + " - Text Editor");
					 output.close();
				 }catch(Exception ex) { }
			}
		}
		else if(event.getSource() == printMenuItem)
		{
			PrinterJob printerJob = PrinterJob.getPrinterJob();
			if (printerJob.printDialog()) {
		        try {printerJob.print();}
		        catch (PrinterException exc) {
		            System.out.println("Waaaa");
		         }
		     }
		}
		else if(event.getSource() == exitMenuItem)
		{
			System.exit(0);
		}
		else if(event.getSource() == cutMenuItem)
		{
			try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_X);
			r.keyRelease(KeyEvent.VK_CONTROL);
			} catch (Exception e) {}
		}
		else if(event.getSource() == copyMenuItem)
		{
			try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			} catch (Exception e) {}
		}
		else if(event.getSource() == pasteMenuItem)
		{
			try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			} catch (Exception e) {}
		}
		else if(event.getSource() == deleteMenuItem)
		{
			try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);
			} catch (Exception e) {}
		}
		else if(event.getSource() == selectAllMenuItem)
		{
			try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			} catch (Exception e) {}
		}
		else if(event.getSource() == backgroundColorMenuItem)
		{
			//JFontChooser fontChooser = new JFontChooser();
			Color color = JColorChooser.showDialog(editorScrollPane, "Choose Background Color",Color.WHITE);
			editorTextArea.setBackground(color);
			
		}
		else if(event.getSource() == textColorMenuItem)
		{
			//JFontChooser fontChooser = new JFontChooser();
			Color color = JColorChooser.showDialog(editorScrollPane, "Choose Text Color",Color.BLACK);
			editorTextArea.setForeground(color);	
		}
		else if(event.getSource() == statusBarMenuItem)
		{
			if(statusBarMenuItem.getState() == false)
			{
				statusBarPanel.setVisible(false);
			}
			else
			{
				statusBarPanel.setVisible(true);
			}
		}
		//else if(event.getSource() == )
		else if(event.getSource() == timeDateMenuItem)
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			String s1 = editorTextArea.getText();
			s1 += dtf.format(now);
			editorTextArea.setText(s1);
		}
		else if(event.getSource() == wordWrapMenuItem)
		{
			if(wordWrapMenuItem.getState())
			{
				editorTextArea.setLineWrap(true);
			}
			else
			{
				editorTextArea.setLineWrap(false);
			}
		}
		else if(event.getSource() == aboutTextEditorMenuItem)
		{
			new aboutDialogBox();
			
		}
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent event) {
		if(keyPressed == true)
		{
			Object[] options = {"Save", "Don't Save", "Cancel"};
			int result = JOptionPane.showOptionDialog(frame, "Do you want to save " + frame.getTitle().substring(0, frame.getTitle().length() - 14), "Text Editor", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if(result == 0)
			{
				
			}
			else if(result == 1)
			{
				frame.dispose();
			}
		}
		else
		{
			frame.dispose();
		}
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		keyPressed = true;
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class aboutDialogBox
{
	public JDialog about;
	public aboutDialogBox()
	{
		JFrame frame= new JFrame();  
        about = new JDialog(frame , "About Text Editor", true);  
        about.setLayout( new FlowLayout() );  
        JLabel label= new JLabel("Developed by Paras Gupta");
        JButton button = new JButton ("OK");  
        button.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
               about.setVisible(false);  
            }  
        });  
        about.add(label);
        about.add(button);   
        about.setSize(200,100);
        about.setVisible(true);
    }
}


