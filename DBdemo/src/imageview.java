import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.sql.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
public class imageview extends JFrame {
	JLabel label;
	JButton button, choose;
   imageview(){}
   imageview(String s){
	   super(s);
   }
   
   public void setView() {
	  label = new JLabel();
	  button = new JButton("show image");
	  choose = new JButton("Choose");
	  setLayout(null);
	  label.setBounds(20, 20, 400, 400);
	  choose.setBounds(150, 430, 100, 30);
	  button.setBounds(20, 430, 100, 30);
	  
	  add(label); add(button); add(choose);
	  button.addActionListener(new Handler());
	  choose.addActionListener(new selectFile());
	   
	   
   }
   
   public class Handler implements ActionListener {
	   public void actionPerformed(ActionEvent f) {
		 try {
			 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
			 Statement st = conn.createStatement();
			 ResultSet result = st.executeQuery("SELECT * FROM image WHERE id = 3");
			 if (result.next()) {
				 byte[] img = result.getBytes("image");
				 ImageIcon image = new ImageIcon(img);
				 Image im = image.getImage();
				 ImageIcon newimage = new ImageIcon(im);
				 label.setIcon(newimage);
			 }
		 }
		 catch(Exception e) {
			  System.out.println("cant open database "+e.getMessage()); 
		 }
		   
	   }
   }
   
    class selectFile implements ActionListener{
	   public void actionPerformed(ActionEvent g){
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
			   PreparedStatement ps = conn.prepareStatement("INSERT INTO image (image) VALUES (?)");
			   ps.setBytes(1, bos.toByteArray());
			   num_rows = ps.executeUpdate();
			   if (num_rows>0) {
				   System.out.println("data has been inserted");
			   }
			   ps.close();
			   conn.close();
			  
		   }
		   catch(Exception e) {
			   System.out.println("something went wrong "+e.getMessage());
		   }
		   
	   }
   }
    }
  /* public static void insert() {
	   try {
		   Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
		   FileInputStream fis;
		   int num_rows = 0;
		   File image = new File("C:\\pic1.jpg");
		   fis = new FileInputStream(image);
		   ByteArrayOutputStream bos = new ByteArrayOutputStream();
		   byte[] buf = new byte[1024];
		   for (int readnum; (readnum = fis.read(buf)) != -1;) {
			   bos.write(buf, 0, readnum);
		   }
		   fis.close();
		   PreparedStatement ps = conn.prepareStatement("INSERT INTO image (image) VALUES (?)");
		   ps.setBytes(1, bos.toByteArray());
		   num_rows = ps.executeUpdate();
		   if (num_rows>0) {
			   System.out.println("data has been inserted");
		   }
		   ps.close();
		   conn.close();
		  
	   }
	   catch(Exception e) {
		   System.out.println("something went wrong "+e.getMessage());
	   }
   }*/
   public static void main(String[] args) throws IOException{
	   
	   imageview view = new imageview();
	   view.setView();
	   view.setSize(500, 500);
	   view.setVisible(true);
	   //insert();
	   view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   
   }
   }
