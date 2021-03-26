import java.text.DecimalFormat;


public class Monomial {
	private int power;
	private double coef;
	
	public Monomial(double c, int p) {
		power = p;
		coef = c;
	}
	
	public int getPower() {
		return power;
	}
	public double getCoef() {
		return coef;
	}
	public void negateCoeff() {
		coef = coef * (-1);
	}
	
	public Monomial add(Monomial m) {
		Monomial ad = new Monomial(m.getCoef()+this.getCoef(),m.getPower());
		return ad;
	}
	
	public Monomial sub(Monomial m) {
		Monomial sb = new Monomial(this.getCoef()-m.getCoef(),this.getPower());
		return sb;
	}
	
	public Monomial multiply(Monomial m) {
		Monomial mlt = new Monomial(this.getCoef() * m.getCoef(),this.getPower() + m.getPower());
		return mlt;
	}
	
	public Monomial div(Monomial m) {
		Monomial dv = new Monomial(this.getCoef() / m.getCoef(), this.getPower()-m.getPower());
		return dv;
	}
	
	public Monomial deriv() {
		Monomial drv = new Monomial(this.getCoef() * this.getPower(), this.getPower()-1);
		return drv;
	}
	
	public Monomial integrate() {
		Monomial itg = new Monomial(this.getCoef() / (this.getPower()+1), this.getPower()+1);
		return itg;
	}
	
	public int smallerPower(Monomial m2) {
		if (this.getPower() < m2.getPower())
			return 1;
		else if (this.getPower() > m2.getPower())
				return 2;
		return 0;
	}
	
	public String toString() {
		String rez;
		if (this.getPower() > 0) {
			if(this.getCoef() <= 0)
				rez = "- " + String.valueOf(new DecimalFormat("###.#").format(Math.abs(this.getCoef())) + "X^" + this.getPower());
			else
				rez = "+ " + String.valueOf(new DecimalFormat("###.#").format(Math.abs(this.getCoef())) + "X^" + this.getPower());
		}
		else {
				if(this.getCoef() <= 0)
					rez = "-" + String.valueOf(new DecimalFormat("###.#").format(Math.abs(this.getCoef())));
				else
					rez = String.valueOf(new DecimalFormat("###.#").format(Math.abs(this.getCoef())));
				}
		return rez;
	}
}
