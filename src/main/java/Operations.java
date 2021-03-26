import java.util.ArrayList;
import java.util.List;

public class Operations {
	public Operations() {	
	}
		
	public Polynomial add(Polynomial p1, Polynomial p2) {
		List<Monomial> monL = new ArrayList<Monomial>();
		int i = 0; Monomial m1 = p1.getList().get(i);
		int j = 0; Monomial m2 = p2.getList().get(j);
		while((i < p1.getList().size()) && (j < p2.getList().size())) {
			m1 = p1.getList().get(i);
		    m2 = p2.getList().get(j);
			switch (m1.smallerPower(m2)) {
			case 1:
				monL.add(m1);
				i = i + 1;
				break;
			case 2:
				monL.add(m2);
				j = j + 1;
				break;
			default:
				m1 = m1.add(m2);
				monL.add(m1);
				i = i + 1;
				j = j + 1;
				break;
			}
		}
			while (i < p1.getList().size()) {
				m1 = p1.getList().get(i);
				monL.add(m1);
				i = i + 1;
			}
			while (j < p2.getList().size()) {
				m2 = p2.getList().get(j);
				monL.add(m2);
				j = j + 1;
			}
		Polynomial add = new Polynomial(monL);
		add = add.removeZeroCoef();
		return add;
	}
	
	public Polynomial sub(Polynomial p1, Polynomial p2) {
		p2 = negate(p2);
		Polynomial sub = add(p1, p2);
		sub = sub.removeZeroCoef();
		return sub;
	}

	public Polynomial multiply(Polynomial p1, Polynomial p2) {
		List<Monomial> monL = new ArrayList<Monomial>();
		monL.add(new Monomial(0,0));
		Polynomial auxMultiply = new Polynomial(monL);
		monL.clear();
		for(Monomial m1: p1.getList()) {
			for(Monomial m2: p2.getList()) {
				Monomial m = m1.multiply(m2);
				monL.add(m);
			}
			Polynomial sm = new Polynomial(monL);
			auxMultiply = add(auxMultiply,sm);
			monL.clear();
		}
		List<Monomial> mL = auxMultiply.getList();
		Polynomial mlt = new Polynomial(mL);
		mlt = mlt.removeZeroCoef();
		return mlt;
	}

	public Polynomial div(Polynomial p) {
		return p;
	}

	public Polynomial deriv(Polynomial p) {
		List<Monomial> monL = new ArrayList<Monomial>();
		for(Monomial m: p.getList()) {
			m = m.deriv();
			monL.add(m);
		}
		Polynomial drv = new Polynomial(monL);
		drv = drv.removeZeroCoef();
		return drv;
	}

	public Polynomial integrate(Polynomial p) {
		List<Monomial> monL = new ArrayList<Monomial>();
		for(Monomial m: p.getList()) {
			m = m.integrate();
			monL.add(m);
		}
		Polynomial itg = new Polynomial(monL);
		itg = itg.removeZeroCoef();
		return itg;
	}
	
	public Polynomial negate(Polynomial p) {
		List<Monomial> monL = new ArrayList<Monomial>();
		for(Monomial m: p.getList()) {
			m.negateCoeff();
			monL.add(m);
		}
		Polynomial neg = new Polynomial(monL);
		return neg;
	}

	
	public static void main (String[] args) {
		Operations o =new Operations();
		Monomial m = new Monomial(3,80);
		Monomial m1 = new Monomial(1,8);
		Monomial m2 = new Monomial (-2,234560);
		List<Monomial> monL = new ArrayList<Monomial>();
		monL.add(m);
		monL.add(m1);
		monL.add(m2);
		Polynomial p = new Polynomial(monL);
		
		Monomial m3 = new Monomial(-3,0);
		Monomial m4 = new Monomial(1,4);
		Monomial m5 = new Monomial (5,6);
		List<Monomial> mL = new ArrayList<Monomial>();
		mL.add(m3);
		mL.add(m4);
		mL.add(m5);
		Polynomial p2 = new Polynomial(mL);
		
		p = o.multiply(p,p2);
		System.out.println(p.toString());
	}

}
