import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;
import java.awt.Image;
import java.awt.event.*;

public class image extends JFrame {
	JFileChooser chooser;
	JLabel label;
	JButton btn, show;
	image(){}
	image(String s) {
		super(s);
	}
	public void set() {
		label = new JLabel();
		btn = new JButton("Browse");
		show = new JButton("show");
		setLayout(null);
		btn.setBounds(20, 300, 100, 30);
		show.setBounds(150, 300, 100, 30);
		label.setBounds(20, 10, 400, 270);
		add(label); add(btn);  add(show);
	  btn.addActionListener(new Handler());
	  show.addActionListener(new showimage());
	}
	public class Handler implements ActionListener  {
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			//chooser.setCurrentDirectory(new File(System.getProperty("C:\\pic1.jpg")));
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "gif");
		    chooser.addChoosableFileFilter(filter);
		    int result = chooser.showOpenDialog(chooser);
		    if (result == JFileChooser.APPROVE_OPTION) {
		    	File selectedfile = chooser.getSelectedFile();
		  String path = selectedfile.getAbsolutePath();
		  try{ 
		        FileInputStream fin=new FileInputStream(path); 
		        int len=(int)path.length(); //Class.forName("com.mysql.jdbc.Driver"); 

		        Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db"); 
		        PreparedStatement ps=con.prepareStatement("INSERT INTO image values( ? )"); 

		        ps.setBinaryStream(1, fin, len); 
		        int status=ps.executeUpdate(); 
		  }
		        catch(Exception g){
		        System.out.println(g); 
		    }
		}
		    else  if (result == JFileChooser.CANCEL_OPTION){
		    	System.out.println("No pic choosen");
		    }
		}
		}
	public class showimage implements ActionListener {
		public void actionPerformed(ActionEvent g) {
			try {
		    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\test.db");
		    Statement st = conn.createStatement();
		    ResultSet result = st.executeQuery("SELECT * FROM image");
		   

		    while (result.next()) {
		    	 /*Blob imageBlob = result.getBlob("image");
				    InputStream binaryStream = imageBlob.getBinaryStream(0, imageBlob.length());
        	    byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
			 InputStream binary = result.getBinaryStream("image");*/

		    	byte[] img = result.getBytes("image");
		    	ImageIcon icon = new ImageIcon(img);
		       Image im = icon.getImage();
		    Image myimg = im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		       ImageIcon newImage = new ImageIcon(myimg);
		       label.setIcon(newImage);
		    }
			}
			catch(SQLException e) {
				System.out.print("cant show image");
			}
		}
	}

	 public static void main(String[] args) throws IOException {
    	 image box = new image();
    	 box.set();
    	 box.setSize(500, 500);
    	 box.setVisible(true);
    	 box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
     }

}
