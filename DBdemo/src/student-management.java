import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
public class connect extends JFrame {
	String[] college = {"MAIT", "BPIT", "NIEC", "MSIT", "DTU", "IILM", "JMI"};
	String[] gender1 = {"Male", "Female", "Other"};
	String[] category1 = {"GENERAL", "OBC", "SC", "ST"};
	String[] course1 = {"B.Tech", "BBA", "BCA", "MBA"};
	/*String info[] = {"Name", "Roll no", "Email", "College"};
	String value[][] = {{"Robin", "56", "rob@gmail.com", "MAIT"}};*/
	JTextField f1, f2, f3, t1, phone, text11, text12;
	String s1, s2, show, coll, gen, cou, cat, ph, search_email;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
	JLabel student_name, student_email, student_college, student_roll, student_course, student_gender, student_category, student_mobile;
	JLabel student_name1, student_email1, student_college1, student_roll1, student_course1, student_gender1, student_category1, student_mobile1;
	JLabel headername;
	JLabel imagelabel;
	JLabel title;
	JComboBox box, gender, category, course;
	JComboBox edit_gender, edit_category, edit_course;
	JDialog dialog;
	JScrollPane scroll;
	JTable table;
	JPanel panel;
	JTextField edit_name, edit_email, edit_roll, edit_contact;
	//JRadioButton male, female;
	int roll, search_roll;
	JButton btn, inf, image, btn1, edit, update, cancel;
	public static final String TABLE_NAME = "student";
	public static final String TABLE_COLUMN_NAME = "name";
	public static final String TABLE_COLUMN_ROLL = "Roll_no";
	public static final String TABLE_COLUMN_EMAIL = "email";
	public static final String TABLE_COLUMN_COLLEGE = "college";
	
	connect(){
		
	}
	
	 connect(String s){
		super(s);
	}
	
	 void setComponent() {
		 box = new JComboBox(college);
		 gender = new JComboBox(gender1);
		 category = new JComboBox(category1);
		 course = new JComboBox(course1);
		 edit_gender = new JComboBox(gender1);
		 edit_category = new JComboBox(category1);
		 edit_course = new JComboBox(course1);
		 
		 f1 = new JTextField();
		 f2 = new JTextField();
		 f3 = new JTextField();
		 t1 = new JTextField();
		 text11 = new JTextField();
		 text12 = new JTextField();
		 phone = new JTextField();
		 edit_name = new JTextField();
		 edit_email = new JTextField();
		 edit_roll = new JTextField();
		 edit_contact = new JTextField();
		 label1 = new JLabel("Enter Student Name");
		 label2 = new JLabel("Enter Student Roll no");
		 label3 = new JLabel("Enter Email");
		 label4 = new JLabel("Choose College");
		 label5 = new JLabel("Find the Student");
		 label6 = new JLabel("Choose Gender");
		 label7 = new JLabel("Choose Category");
		 label8 = new JLabel("Enter Phone no.");
		 label9 = new JLabel("Choose Course");
		 label10 = new JLabel("Choose Image");
		 headername = new JLabel();
		 student_name = new JLabel("Name: "); 
		 student_email = new JLabel("Email: ");
		 student_roll = new JLabel("Roll No.:");
		 student_gender = new JLabel("Gender:");
		 student_course = new JLabel("Course:");
		 student_category = new JLabel("Category:");
		 student_mobile = new JLabel("Contact:");
		 student_college = new JLabel("College:");
		 student_name1 = new JLabel(); 
		 student_email1 = new JLabel();
		 student_roll1 = new JLabel();
		 student_gender1 = new JLabel();
		 student_course1 = new JLabel();
		 student_category1 = new JLabel();
		 student_mobile1 = new JLabel();
		 student_college1 = new JLabel();
	
		 imagelabel = new JLabel();
		 title = new JLabel("Find Student Details");
		 label11 = new JLabel("Enter Email");
		 label12 = new JLabel("Enter Roll No.");
         btn1 = new JButton("Search");
		 btn = new JButton("Insert");
		 inf = new JButton("Show Details");
		 image = new JButton("Choose");
		 edit = new JButton("Edit");
		 update = new JButton("Update");
		 cancel = new JButton("Cancel");
		 panel = new JPanel();
		table = new JTable();
		scroll = new JScrollPane();
		 setLayout(null);
		 f1.setBounds(20, 40, 200, 30);
		 f2.setBounds(20, 110, 200, 30 );
		 f3.setBounds(20, 160, 200, 30 );
		 t1.setBounds(40, 250, 100, 50);
		 phone.setBounds(240, 160, 200, 30);
		 label1.setBounds(20, 17, 200, 15);
		 label2.setBounds(20, 90, 200, 15 );
		 label3.setBounds(20, 140, 200, 15);
		 label4.setBounds(250, 17, 200, 15);
		 label6.setBounds(240, 85, 200, 15);
		 label7.setBounds(400, 17, 100, 15);
		 label8.setBounds(240, 140, 100, 15);
		 label9.setBounds(400, 85, 100, 15);
		 label10.setBounds(450, 140, 100, 15);
		 label11.setBounds(650, 60, 100, 20);
		 label12.setBounds(840, 60, 100, 20 );
		 text11.setBounds(650, 90, 150, 25 );
		 text12.setBounds(840, 90, 150, 25);
		 title.setBounds(650, 17, 300, 30);
		 title.setFont(new Font("serif", Font.BOLD, 25));
		 box.setBounds(250, 40, 100, 30);
		 gender.setBounds(250, 110, 100, 20);
		 category.setBounds(400, 40, 100, 30);
		 course.setBounds(400, 110, 100, 20);
		 btn.setBounds(20, 220, 150, 30);
		 btn1.setBounds(1000, 90, 90, 25);
		 inf.setBounds(200, 220, 150, 30);
		 image.setBounds(450, 160, 100, 30);
		 scroll.setBounds(20,300, 550, 200 );
		 table.setBounds(20, 300, 550, 200);
		 panel.setBounds(650, 160, 450, 370);
		// panel.setBackground(Color.WHITE);
		 imagelabel.setBounds(920, 180, 150, 190);
		 headername.setBounds(930, 390, 200, 30);
		 //imagelabel.setBounds(200, 100, 100, 180);
		 //imagelabel.setBackground(Color.BLUE);
		 student_name.setBounds(680, 180, 60, 20); 
		 student_email.setBounds(680, 220, 60, 20); 
		 student_roll.setBounds(680, 260, 60, 20);
		 student_gender.setBounds(680, 300, 60, 20);
		 student_course.setBounds(680, 340, 60, 20); 
		 student_college.setBounds(680, 380, 60, 20);
		 student_category.setBounds(680, 420, 60, 20);
		 student_mobile.setBounds(680, 460, 60, 20); 
		 student_name1.setBounds(740, 180, 150, 20); 
		 student_email1.setBounds(740, 220, 150, 20); 
		 student_roll1.setBounds(740, 260, 150, 20);
		 student_gender1.setBounds(740, 300, 150, 20);
		 student_course1.setBounds(740, 340, 150,20); 
		 student_college1.setBounds(740, 380, 150, 20);
		 student_category1.setBounds(740, 420, 150, 20);
		 student_mobile1.setBounds(740, 460, 100, 20);
		 edit.setBounds(910, 430, 70, 25);
		 cancel.setBounds(910, 430, 70, 25);
		 update.setBounds(995, 430, 90, 25 );
		 table.setForeground(Color.DARK_GRAY);
		 table.setBackground(Color.PINK);
		 edit_name.setBounds(740, 180, 150, 20);
		 edit_email.setBounds(740, 220, 150, 20);
		 edit_roll.setBounds(740, 260, 150, 20);
		 edit_contact.setBounds(740, 460, 100, 20);
		 edit_course.setBounds(740, 340, 150,20); 
		 edit_category.setBounds(740, 420, 150, 20);
		 edit_gender.setBounds(740, 300, 150, 20);

		 panel.setBackground(Color.WHITE);
		 headername.setFont(new Font("serif", Font.BOLD, 20));
		 headername.setForeground(Color.BLUE);
		 student_name1.setFont(new Font("serif", Font.ITALIC, 15)); student_email1.setFont(new Font("serif", Font.ITALIC, 15));
		 student_roll1.setFont(new Font("serif", Font.ITALIC, 15)); student_gender1.setFont(new Font("serif", Font.ITALIC, 15));
		 student_course1.setFont(new Font("serif", Font.ITALIC, 15)); student_college1.setFont(new Font("serif", Font.ITALIC, 15));
		 student_category1.setFont(new Font("serif", Font.ITALIC, 13)); student_mobile1.setFont(new Font("serif", Font.ITALIC, 15));
		 student_name.setVisible(false); student_email.setVisible(false); student_roll.setVisible(false); student_gender.setVisible(false);
		 student_course.setVisible(false); student_college.setVisible(false); student_category.setVisible(false); student_mobile.setVisible(false);
		 edit.setVisible(false); update.setVisible(false); edit_name.setVisible(false); edit_email.setVisible(false);
		 edit_roll.setVisible(false); edit_contact.setVisible(false); edit_course.setVisible(false); edit_category.setVisible(false);
		 edit_gender.setVisible(false); cancel.setVisible(false);
		
		 add(imagelabel); 
		 add(student_name); 
		 add(student_name1); 
		 add(student_email1); 
		 add(student_roll1); 
		 add(student_gender1); 
		 add(student_course1);

		 add(student_college1); 
		 add(student_category1); 
		 add(student_mobile1);
		 add(student_email); 
		 add(student_roll); 
		 add(student_gender); 
		 add(student_course);
		 add(student_college); 
		 add(student_category); 
		 add(student_mobile); 
		 add(headername);

		 add(f1); 
		 add(f2); 
		 add(f3); 
		 add(text11); 
		 add(text12); 
		 add(btn1);  
		 add(btn); 
		 add(edit);
		 add(update);
		 add(cancel);
		 /*add(t1);*/ 
		 add(box); 
		 add(gender); 
		 add(category); 
		 add(phone); 
		 add(course); 
		 add(label1); 
		 add(label2);
		 add(label3); 
		 add(label4); 
		 add(label6); 
		 add(label7); 
		 add(label8); 
		 add(label9); 
		 add(label10); 
		 add(label11); 
		 add(label12);  
		 add(title); 
		 add(image); 
		 add(inf); 
		 add(edit_name);
		 add(edit_email);
		 add(edit_roll);
		 add(edit_contact);
		 add(edit_gender);
		 add(edit_course);
		 add(edit_category);
		 
		 scroll.setViewportView(table); add(scroll);
		 add(panel);
		 
		 btn.addActionListener(new Handler());
		 inf.addActionListener(new showdata());
		 image.addActionListener(new chooseImage());
		 btn1.addActionListener(new search());
		 edit.addActionListener(new editData());
		update.addActionListener(new update());
		 cancel.addActionListener(new cancel());
		 
	 }
	 
	  public class Handler implements ActionListener {
		 public void actionPerformed(ActionEvent f) {
			s1 = f1.getText();
			s2 = f3.getText();
			roll = Integer.parseInt(f2.getText());
           coll = box.getItemAt(box.getSelectedIndex()).toString();
           gen = gender.getItemAt(gender.getSelectedIndex()).toString();
           cou = course.getItemAt(course.getSelectedIndex()).toString();
           cat = category.getItemAt(category.getSelectedIndex()).toString();
           ph = phone.getText();
            
       		 try {
       			 
				 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
				 System.out.print("database has been created\n");
				 Statement statement = conn.createStatement();
				 //statement.execute("CREATE TABLE IF NOT EXISTS student(name TEXT, Roll_no INTEGER, email TEXT)");
				 statement.execute("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+TABLE_COLUMN_NAME+" TEXT, "+TABLE_COLUMN_ROLL+" INTEGER, "+TABLE_COLUMN_EMAIL+" TEXT)");
				 statement.execute("INSERT INTO student(name, Roll_no, email, college, gender, phone, category, course) VALUES ('"+s1+"', '"+roll+"', '"+s2+"', '"+coll+"', '"+gen+"', '"+ph+"', '"+cat+"', '"+cou+"')");
				 //statement.execute("INSERT INTO "+TABLE_NAME+"("+TABLE_COLUMN_NAME+", "+TABLE_COLUMN_ROLL+", "+TABLE_COLUMN_EMAIL+", "+TABLE_COLUMN_COLLEGE+")"+" VALUES"+ "("+"'"+s1+"', '"+roll+"', '"+s2+"', '"+coll+"' ");
                 /*ResultSet result = statement.executeQuery("SELECT name FROM student WHERE Roll_no = 56");
                 while(result.next()) {
            	   t1.setText(result.getString("name"));
                 }*/
				 JOptionPane.showMessageDialog(new JFrame(), "Information Has been Inserted",
						 "information", JOptionPane.INFORMATION_MESSAGE);
				 
				 
              }
       		 
			 catch(SQLException e){
				 System.out.println("something went wrong " + e.getMessage());
			 }
       		 
	
		 }
	 }
	  
	  public class chooseImage implements ActionListener {
			 public void actionPerformed(ActionEvent r) {
				 s2 = f3.getText();
				   roll = Integer.parseInt(f2.getText());
				   if (s2.isEmpty()) {
					   JOptionPane.showMessageDialog(null, "Please Enter Email", "Wrong", JOptionPane.ERROR_MESSAGE);
				   }
				   else {
				 JFileChooser chooser = new JFileChooser();
					//chooser.setCurrentDirectory(new File(System.getProperty("C:\\pic1.jpg")));
				    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "gif");
				    chooser.addChoosableFileFilter(filter);
				    int result = chooser.showOpenDialog(chooser);
				    if (result == JFileChooser.APPROVE_OPTION) {
				    	File selectedfile = chooser.getSelectedFile();
				    	String path = selectedfile.getAbsolutePath();
					   try {
						   Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
						   FileInputStream fis;
						   int num_rows = 0;
						   File image = new File(path);
						   fis = new FileInputStream(image);
						   ByteArrayOutputStream bos = new ByteArrayOutputStream();
						   byte[] buf = new byte[1024];
						   for (int readnum; (readnum = fis.read(buf)) != -1;) {
							   bos.write(buf, 0, readnum);
						   }
						   fis.close();
						   PreparedStatement ps = conn.prepareStatement("INSERT INTO profile (Roll_no, email, image) VALUES (?, ?, ?)");
						   ps.setInt(1, roll);
						   ps.setString(2, s2);
						   ps.setBytes(3, bos.toByteArray());
						   num_rows = ps.executeUpdate();
						   if (num_rows>0) {
							   System.out.println("data has been inserted");
						   }
						
						    }
					   	catch(Exception e) {
						   System.out.println("something went wrong "+e.getMessage());
					   	}
				    }
				   }
			 }
			 }
	 public class showdata implements ActionListener {
		 public void actionPerformed(ActionEvent f) {

			 try {
				 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
				 Statement statement = conn.createStatement();
				 ResultSet result = statement.executeQuery("SELECT name, email, Roll_no, college, gender FROM "+TABLE_NAME);
	             table.setModel(DbUtils.resultSetToTableModel(result));
	             
			 }
			 catch (SQLException e){
				System.out.println(e.getMessage()); 
			 }
			 
		 }
	 }
	 public class search implements ActionListener {
		 public void actionPerformed(ActionEvent s) {
			 search_email = text11.getText();
			 search_roll = Integer.parseInt(text12.getText());
			 if (search_email.isEmpty()) {
				 JOptionPane.showMessageDialog(null, "Please Enter Email Address", "Please Enetr", JOptionPane.INFORMATION_MESSAGE);
			 }
			 else {
					 try {
				 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
				 Statement st = conn.createStatement();
				 ResultSet result = st.executeQuery("SELECT student.*, profile.image FROM student, profile  WHERE student.Roll_no = '"+search_roll+"' AND profile.Roll_no = '"+search_roll+"'");
				 if (result.next()) {
					 byte[] img = result.getBytes("image");
					 ImageIcon image = new ImageIcon(img);
					 Image im = image.getImage();
					 Image resize = im.getScaledInstance(150, 190, Image.SCALE_FAST);
					 ImageIcon newimage = new ImageIcon(resize);
					// BufferedImage image2 = ImageIO.read(newimage);
					// BufferedImage resized = resize(newimage, 200, 200);
					 
					 imagelabel.setIcon(newimage);
					 String name = result.getString("name");
					 String email = result.getString("email");
					 String gender = result.getString("gender");
					 String corse = result.getString("course");
					 String college = result.getString("college"); 
					 String category = result.getString("category");
					 String phone = result.getString("phone");
					 String roll = result.getString("Roll_no");
					 student_name1.setText(name);
					 student_email1.setText(email); 
					 student_gender1.setText(gender);
					 student_course1.setText(corse); 
					 student_college1.setText(college); 
					 student_roll1.setText(roll);
					 student_category1.setText(category); 
					 student_mobile1.setText(phone); 
					 headername.setText(name);
					 edit_name.setText(name);
					 edit_email.setText(email); 
					 edit_roll.setText(roll);
					 edit_contact.setText(phone);
					 student_name.setVisible(true);  
					 student_email.setVisible(true);  
					 student_roll.setVisible(true); 
					 student_gender.setVisible(true);  
					 student_course.setVisible(true);  
					 student_college.setVisible(true);
					 student_category.setVisible(true); 
					 student_mobile.setVisible(true);
					 edit.setVisible(true);
					 //panel.setBackground(Color.WHITE);
					 conn.close();
					 
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Please Enter Correct Roll no", "Wrong", JOptionPane.ERROR_MESSAGE);
					 
				 }
				
			 }
			 catch(Exception e) {
				  System.out.println("cant open database "+e.getMessage()); 
			 }
			 }
			 
		 }
	 }
	 public class editData implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			
				 edit_name.setVisible(true);
				 edit_email.setVisible(true);
				 edit_roll.setVisible(true);
				 edit_contact.setVisible(true);
				 edit_gender.setVisible(true);
				 edit_course.setVisible(true);
				 edit_category.setVisible(true);
				 update.setVisible(true);
				 edit.setVisible(false);
				 cancel.setVisible(true);
				 student_name1.setVisible(false); student_email1.setVisible(false); student_roll1.setVisible(false); student_gender1.setVisible(false);
				 student_course1.setVisible(false); student_college1.setVisible(false); student_category1.setVisible(false); student_mobile1.setVisible(false);
				 text11.setEditable(false); text12.setEditable(false);
				 
		 
			
		 }
	 }
	 public class cancel implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 edit_name.setVisible(false); edit_email.setVisible(false);
			 edit_roll.setVisible(false); edit_contact.setVisible(false); edit_course.setVisible(false); edit_category.setVisible(false);
			 edit_gender.setVisible(false);  student_name.setVisible(true);  
			 student_email1.setVisible(true);  
			 student_roll1.setVisible(true); 
			 student_gender1.setVisible(true);  
			 student_course1.setVisible(true);  
			 student_college1.setVisible(true);
			 student_category1.setVisible(true); 
			 student_mobile1.setVisible(true);
			 student_name1.setVisible(true);
			 cancel.setVisible(false); update.setVisible(false); edit.setVisible(true); text11.setEditable(true); text12.setEditable(true);
			
		 }
	 }
	 public class update implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 String name = edit_name.getText();
			 String email = edit_email.getText();
			 int roll = Integer.parseInt(edit_roll.getText());
			 String contact = edit_contact.getText();
			String course = edit_course.getItemAt(edit_course.getSelectedIndex()).toString();
			String gender = edit_gender.getItemAt(edit_gender.getSelectedIndex()).toString();
			String category = edit_category.getItemAt(edit_category.getSelectedIndex()).toString();
			int search_roll = Integer.parseInt(text12.getText());
			try {
				 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
				 Statement stat= conn.createStatement();
				 stat.execute("update student set name = '"+name+"', email = '"+email+"', Roll_no = '"+roll+"', gender = '"+gender+"', course = '"+course+"',category = '"+category+"', phone = '"+contact+"' where Roll_no = '"+search_roll+"'");
				 stat.execute("update profile set Roll_no = '"+roll+"', email = '"+email+"' where Roll_no = '"+search_roll+"'");
				 JOptionPane.showMessageDialog(new JFrame(), "Information Has been Updated",
						 "Information", JOptionPane.INFORMATION_MESSAGE);
				 ResultSet result = stat.executeQuery("SELECT student.*, profile.image FROM student, profile  WHERE student.Roll_no = '"+roll+"' AND profile.Roll_no = '"+roll+"'");
				 if (result.next()) {
					 byte[] img = result.getBytes("image");
					 ImageIcon image = new ImageIcon(img);
					 Image im = image.getImage();
					 Image resize = im.getScaledInstance(150, 190, Image.SCALE_FAST);
					 ImageIcon newimage = new ImageIcon(resize);
					 
					 imagelabel.setIcon(newimage);
					  student_name1.setText( result.getString("name"));
					  student_email1.setText( result.getString("email"));
					  student_gender1.setText( result.getString("gender"));
					  student_course1.setText( result.getString("course"));
					  student_college1.setText( result.getString("college"));
					  student_category1.setText( result.getString("category"));
					  student_mobile1.setText( result.getString("phone"));
					  student_roll1.setText( result.getString("Roll_no"));
					  headername.setText(result.getString("name"));
				
				 student_email1.setVisible(true);  
				 student_roll1.setVisible(true); 
				 student_gender1.setVisible(true);  
				 student_course1.setVisible(true);  
				 student_college1.setVisible(true);
				 student_category1.setVisible(true); 
				 student_mobile1.setVisible(true);
				 student_name1.setVisible(true);
				 edit_name.setVisible(false); edit_email.setVisible(false);
				 edit_roll.setVisible(false); edit_contact.setVisible(false); edit_course.setVisible(false); edit_category.setVisible(false);
				 edit_gender.setVisible(false);
				 cancel.setVisible(false); update.setVisible(false); edit.setVisible(true); text11.setEditable(true); text12.setEditable(true); 
				
				
				 }
				 conn.close();
			}
			catch(Exception f) {
				System.out.print("value not updated "+f.getMessage());
			}
			 
		 }
	 }
	 
 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException  {
	 
	 connect frame = new connect("Student Management System");
	 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	 frame.setComponent();
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setSize(1200, 600);
	// frame.setResizable(false);
	 }

}
