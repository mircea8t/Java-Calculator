import java.awt.event.*;


public class Control {
	private Fereastra calc;
	private Operations op;
	
	public Control(Fereastra f, Operations o) {
		this.calc = f;
		this.op = o;
		f.addActionListener(new Add(), new Sub(), new Multiply(), new Derivate1(), new Derivate2(), new Integrate1(), new Integrate2());
	}
	
	class Add implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = calc.citireText1();
			Polynomial p2 = calc.citireText2();
			Polynomial add = op.add(p1,p2);
			calc.setRezultat(add);
		}
	}
	
	class Sub implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = calc.citireText1();
			Polynomial p2 = calc.citireText2();
			Polynomial sub = op.sub(p1,p2);
			calc.setRezultat(sub);
		}
	}
	
	class Multiply implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = calc.citireText1();
			Polynomial p2 = calc.citireText2();
			Polynomial mult = op.multiply(p1,p2);
			calc.setRezultat(mult);
		}
	}
	
	class Derivate1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = calc.citireText1();
			p1 = op.deriv(p1);
			calc.setRezultat(p1);
		}
	}
	
	class Derivate2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p2 = calc.citireText2();
			p2 = op.deriv(p2);
			calc.setRezultat(p2);
		}	
	}
	
	class Integrate1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = calc.citireText1();
			p1 = op.integrate(p1);
			calc.setRezultat(p1);
		}	
	}
	
	class Integrate2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p2 = calc.citireText2();
			p2 = op.integrate(p2);
			calc.setRezultat(p2);
		}	
	}
}
