import java.util.*;

public class Polynomial {
	private List<Monomial> monList = new ArrayList<Monomial>();
	
	public Polynomial(List<Monomial> monL) {
		for(Monomial m: monL) {
			monList.add(m);
		}
	}
	
	public List<Monomial> getList(){
		return this.monList;
	}
	
	public Polynomial removeZeroCoef(){
		Iterator<Monomial> it = monList.iterator();
		while(it.hasNext()) {
			Monomial m = (Monomial)it.next();
			if (m.getCoef() == 0)
				it.remove();
		}
		Polynomial p = new Polynomial(this.monList);
		return p;
	}
	
	public Polynomial aranjarePol() {
		List<Monomial> aux = this.getList();
		List<Monomial> nList = new ArrayList<Monomial>();
		while(aux.size() > 0 ) {
			Monomial min = aux.get(0);
			for(Monomial m:aux) {
				if (m.getPower() < min.getPower())
					min = m;
			}
			nList.add(min);
			Iterator<Monomial> it = aux.iterator();
			while(it.hasNext()) {
				Monomial m = (Monomial)it.next();
				if (m.getPower() == min.getPower())
					it.remove();
			}
		}
		Polynomial aranj = new Polynomial(nList);
		return aranj;
	}
	
	public String toString() {
		String rez="";
		for(Monomial m: this.monList) {
			rez = rez + ' ' + m.toString();
		}
		return rez;
	}
}
