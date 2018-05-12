import java.sql.*;
import java.io.*;
import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
public class combobox extends JFrame {
	public JComboBox box;
	public JButton button;
     combobox(){}
     combobox(String s){
    	 super(s);
     }
     public void setDesign() {
    	 box = new JComboBox();
    	 button = new JButton("insert");
    	 setLayout(null);
    	 box.setBounds(20, 40, 100, 30);
    	 button.setBounds(20, 120, 70, 30);
    	 add(box); add(button);
    	 button.addActionListener(new Handler());
    	 
     }
     public class Handler implements ActionListener {
    	 public void actionPerformed(ActionEvent f) {
    		 try {
    			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
    			 Statement statement = conn.createStatement();
    			 ResultSet result = statement.executeQuery("SELECT name FROM student");
                 while(result.next()) {
              	   box.addItem(result.getString("name"));
                 }
    			 
    		 }
    		 catch(SQLException e) {
    			 System.out.print(e.getMessage());
    		 }
    	 }
     }
     public static void main(String[] args) {
    	 combobox box = new combobox();
    	 box.setDesign();
    	 box.setSize(500, 500);
    	 box.setVisible(true);
    	 box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
