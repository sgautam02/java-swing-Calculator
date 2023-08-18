 import java.awt.event.*;
 import java.awt.*;
import javax.swing.*;

public class MainFrame implements ActionListener{

    JFrame farme;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] funcButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton,decButton,equButton, delButton,clrButton;
    JPanel panel;

    double num1=0,num2=0,result=0;
    char operator;


    MainFrame(){

        farme=new JFrame("Calculator");
        farme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        farme.setSize(420, 550); 
        farme.setLayout(null);

        textField =new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");

        funcButtons[0]=addButton;
        funcButtons[1]=subButton;
        funcButtons[2]=mulButton;
        funcButtons[3]=divButton;
        funcButtons[4]=decButton;
        funcButtons[5]=equButton;
        funcButtons[6]=delButton;
        funcButtons[7]=clrButton;

        for(int i=0; i<8;i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFocusable(false);

        }
        for(int i=0; i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

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
        farme.add(delButton);
        farme.add(clrButton);
        farme.add(textField);
        farme.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            
            switch(operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==delButton){
            String string= textField.getText(); 
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
       
    }
}
