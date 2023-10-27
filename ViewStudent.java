import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;


class ViewStudent extends JFrame 
{

	Container c ;
	TextArea taData;
	JButton btnBack;


	ViewStudent()
	{
		c = getContentPane();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,30,10);
		c.setLayout(fl);
		Font f = new Font("Calibri", Font.BOLD,30);

		taData = new TextArea(2,20);
		btnBack = new JButton("Back TO Home");
		
		taData.setFont(f);
		btnBack.setFont(f);

Configuration cfg  = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();

Session s = null;

try{
	s = sf.openSession();
	System.out.println("connected");


	java.util.List<Student>stu = new java.util.ArrayList<>();
	stu = s.createQuery("from Student").list();

	StringBuffer sb = new StringBuffer();
	for(Student ss:stu)
{

	sb.append("rno = "+ss.getRno() + "name =" + ss.getName()  + "\n");

}
taData.setText(sb.toString());

}catch(Exception e){

	System.out.println("Issue" + e);

}finally{

s.close();
	System.out.println("closed");


}

	c.add(taData);
	c.add(btnBack);

	ActionListener a1 = (ae) ->{

		Home h = new Home();
		dispose();
};

btnBack.addActionListener(a1);
taData.setEditable(false);

setTitle("S.M.S.");
setSize(500,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
	

	
}	



}