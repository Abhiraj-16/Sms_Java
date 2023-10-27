import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home extends JFrame
{

	Container c;
	JButton btnAdd ,btnView;

	Home()
	{
		c = getContentPane();
		FlowLayout  fl = new FlowLayout(FlowLayout.CENTER,30,30);
		c.setLayout(fl);
		Font f = new Font("Calibri", Font.BOLD,30);

		btnAdd = new JButton("Add Student");
		btnView = new JButton("View Student");
	
		btnAdd.setFont(f);
		btnView.setFont(f);

		c.add(btnAdd);
		c.add(btnView);

		ActionListener a1 = (ae) -> {

			AddStudent a = new AddStudent();
			dispose();
		};
		btnAdd.addActionListener(a1);
	
		ActionListener a2 = (ae) -> {

			ViewStudent a = new ViewStudent();
			dispose();
		};
		btnView.addActionListener(a2);


		setTitle("S.M.S.");
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);	


	}


}