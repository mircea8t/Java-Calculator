import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;

public class Fereastra extends JFrame {
	private JFrame frame = new JFrame();
	private JLabel p1 = new JLabel ("Polynomial1:");
	private JLabel p2 = new JLabel ("Polynomial2:");
	private JTextField p1Text = new JTextField();
	private JTextField p2Text = new JTextField();
	private JTextField rez = new JTextField();
	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mlt = new JButton("*");
	private JButton div = new JButton("/");
	private JButton drv1 = new JButton("Derivative");
	private JButton itg1 = new JButton("Integratal");
	private JButton drv2 = new JButton("Derivative");
	private JButton itg2 = new JButton("Integratal");
	private Citire c = new Citire();
	
	public Fereastra() {
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setFont(new Font("Serif", Font.PLAIN, 30));
		p2.setFont(new Font("Serif", Font.PLAIN, 30));
		rez.setPreferredSize(new Dimension(400,40));
		rez.setEditable(false);
		p1Text.setPreferredSize(new Dimension(200,40));
		p2Text.setPreferredSize(new Dimension(200,40));
		
		JPanel panel1 = new JPanel();
		panel1.add(p1);
		panel1.add(p1Text);
		panel1.add(drv1);
		panel1.add(itg1);
		
		JPanel panel2 = new JPanel();
		panel2.add(p2);
		panel2.add(p2Text);
		panel2.add(drv2);
		panel2.add(itg2);
		
		JPanel panel3 = new JPanel();
		panel3.add(rez);
		
		JPanel panel4 = new JPanel();
		panel4.add(add);
		panel4.add(sub);
		panel4.add(mlt);
		panel4.add(div);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout( new BoxLayout(panel5, BoxLayout.Y_AXIS));
		panel5.add(panel1);
		panel5.add(panel2);
		panel5.add(panel3);
		panel5.add(panel4);
		
		frame.setContentPane(panel5);
		frame.setVisible(true);
	}
	
	public void addActionListener(ActionListener add, ActionListener sub, ActionListener mult, ActionListener drv1, ActionListener drv2, ActionListener itg1, ActionListener itg2) {
		this.add.addActionListener(add);
		this.sub.addActionListener(sub);
		this.mlt.addActionListener(mult);
		this.drv1.addActionListener(drv1);
		this.drv2.addActionListener(drv2);
		this.itg1.addActionListener(itg1);
		this.itg2.addActionListener(itg2);
	}
	
	public void setRezultat(Polynomial p) {
		this.rez.setText(p.toString());
	}
	
	public void setPol1(Polynomial p) {
		this.p1Text.setText(p.toString());
	}
	
	public void setPol2(Polynomial p) {
		this.p2Text.setText(p.toString());
	}
	
	public Polynomial citireText1() {
		String pol = this.p1Text.getText();
		String[] numere = new String[20];
		Pattern pt = Pattern.compile("([+-]?[^-+]+)");
		Matcher match = pt.matcher(pol);
		 List<Monomial> mList = new ArrayList<Monomial>();
		int i = 0;
		while(match.find()) {
			numere[i] = match.group(1);
			numere[i] = c.removeSpace(numere[i]);
			if (c.validareText(numere[i]) == false) {
				this.p2Text.setText("Wrong input");
				Polynomial p =new Polynomial(mList);
			    return p;
			}
			i = i + 1;
		}
		for(int j=0; j<i; j++) {
			Monomial m = c.stringToMonomial(numere[j]);
			mList.add(m);
		}
	    Polynomial p =new Polynomial(mList);
	    return p;
	}
	
	public Polynomial citireText2() {
		String pol = this.p2Text.getText();
		String[] numere = new String[20];
		Pattern pt = Pattern.compile("([+-]?[^-+]+)");
		Matcher match = pt.matcher(pol);
		List<Monomial> mList = new ArrayList<Monomial>();
		int i = 0;
		while(match.find()) {
			numere[i] = match.group(1);
			numere[i] = c.removeSpace(numere[i]);
			if (c.validareText(numere[i]) == false) {
				this.p2Text.setText("Wrong input");
				Polynomial p =new Polynomial(mList);
			    return p;
			}
			i = i + 1;
		}
		for(int j=0; j<i; j++) {
			Monomial m = c.stringToMonomial(numere[j]);
			mList.add(m);
		}
	    Polynomial p =new Polynomial(mList);
	    return p;
	}
}
