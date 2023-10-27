import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


class AddStudent extends JFrame
{

	Container c;
	JLabel labRno , labName;
	JTextField txtRno , txtName;
	JButton btnSave, btnBack;

	AddStudent()
	{

		c = getContentPane();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,30,10);
		c.setLayout(fl);
		Font f = new Font("Calibri" ,Font.BOLD + Font.ITALIC,30);


		labRno = new JLabel ("enter stu rno");
		txtRno = new JTextField(15);
		labName = new JLabel("enter stu name");
		txtName = new JTextField(15);
		btnSave = new JButton("Save Student");
		btnBack = new JButton("Back to Home");

		labRno.setFont(f);
		txtRno.setFont(f);
		labName.setFont(f);
		txtName.setFont(f);
		btnSave.setFont(f);
		btnBack.setFont(f);
		
		c.add(labRno);
		c.add(txtRno);
		c.add(labName);
		c.add(txtName);
		c.add(btnSave);
		c.add(btnBack);


		ActionListener a1 = (ae)->{

			Home h  = new Home();
			dispose();
		};
		btnBack.addActionListener(a1);


			ActionListener a2 = (ae)->{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
	
		Session s = null;
		Transaction t = null;

		try{

			s = sf.openSession();
			System.out.println("Connected");
			

			int rno = Integer.parseInt(txtRno.getText());
			String name = txtName.getText();
			Student stu = new Student(rno , name);


			t = s.beginTransaction();
			s.save(stu);
			t.commit();
			JOptionPane.showMessageDialog(c,"record created");
		
			}catch(Exception e){
				if(t !=null){

			t.rollback();
	
			}
			JOptionPane.showMessageDialog(c,"Issue" + e);

			}finally{

				if(s != null){
				s.close();
				}		

			}
		};
		btnSave.addActionListener(a2);
	
		setTitle("S.M.S");
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);



	}


}