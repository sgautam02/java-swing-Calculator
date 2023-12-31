import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
class calculator extends JFrame implements ActionListener {
	static Frame farme;
    static JTextField textField;
    static JButton[] numberButtons=new JButton[10];
    static JButton[] funcButtons = new JButton[8];
    static JButton addButton, subButton, mulButton, divButton,decButton,equButton,clrButton,hisButton;
    static JPanel panel;
	String s0, s1, s2;
	static String t1,t2,t3,t4,t5;
	static String[] h=new String[10];
    
	calculator()
	{
		s0 = s1 = s2 = "";
	}

	public static void main(String args[])
	{
        

		// create a frame
		

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		calculator c = new calculator();

		// create a textfield
		farme=new JFrame("Calculator");
        farme.setSize(420, 550); 
        farme.setLayout(null);

        textField =new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(true);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        clrButton=new JButton("Clear");
		hisButton=new JButton("History");

        funcButtons[0]=addButton;
        funcButtons[1]=subButton;
        funcButtons[2]=mulButton;
        funcButtons[3]=divButton;
        funcButtons[4]=decButton;
        funcButtons[5]=equButton;
        funcButtons[6]=clrButton;
		funcButtons[7]=hisButton;

        for(int i=0; i<8;i++){
            funcButtons[i].addActionListener(c);
            funcButtons[i].setFocusable(false);

        }
        for(int i=0; i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(c);
            numberButtons[i].setFocusable(false);
        }
        clrButton.setBounds(50,430,145,50);
		hisButton.setBounds(200,430,145,50);

        panel=new JPanel();
        panel.setBounds(50, 100, 300, 300);
        
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
         panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
         panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        farme.add(panel);
        farme.add(clrButton);
		farme.add(hisButton);
        farme.add(textField);
        farme.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		// if the value is a number
		try{if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			textField.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			textField.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te;

			// store the value in 1st
			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));

			// set the value of text
			textField.setText(s0 + s1 + s2 + "=" + te);

			CalculatorHistory.addHistoryEntry(textField.getText());


			// convert it to string
			s0 = Double.toString(te);

			s1 = s2 = "";
		}
		else if(s.charAt(0)=='H'){
				ArrayList<String> history = CalculatorHistory.getHistory();
                StringBuilder historyText = new StringBuilder("Calculation History:\n");
                for (String entry : history) {
                    historyText.append(entry).append("\n");
                }
                JOptionPane.showMessageDialog(farme, historyText.toString(), "History", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			// if there was no operand
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double te;

				// store the value in 1st
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te =(Double.parseDouble(s0) * Double.parseDouble(s2));
					t2=Double.toString(te);
				// convert it to string
				s0 = Double.toString(te);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
				//history(Double.toString(te));
			}

			// set the value of text
			textField.setText(s0 + s1 + s2);

			// String input = textField.getText();
            // //double result = te;
			// CalculatorHistory.addHistoryEntry(input);
			
			
		}}catch(Exception ex){System.out.println(ex);}
	}
	
}

// class CalculatorHistory {
//     private static ArrayList<String> history = new ArrayList<>();

//     public static void addHistoryEntry(String entry) {
//         history.add(entry);
//     }

//     public static ArrayList<String> getHistory() {
//         return history;
//     }
// }






