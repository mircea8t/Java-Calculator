
public class Citire {
	public Citire() {
		
	}
	
	public String removeSpace(String s) {
		String g="";
		for(int i=0;i<s.length();i++)
			if(s.charAt(i) != ' ')
				g = g + s.charAt(i);
		return g;
	}
	
	public static int parcurgereCoeff(String s, int i) {
		while(s.charAt(i) =='0' || s.charAt(i) =='1' || s.charAt(i) =='2' || s.charAt(i) =='3' || s.charAt(i) =='4' || s.charAt(i) =='5' || s.charAt(i) =='6' || s.charAt(i) =='7' || s.charAt(i) =='8' || s.charAt(i) =='9' || s.charAt(i) =='.') {
			i = i + 1;
		}
		return i;
	}
	
	public static int parcurgerePower(String s, int i) {
		while(i<s.length()&&(s.charAt(i) =='0' || s.charAt(i) =='1' || s.charAt(i) =='2' || s.charAt(i) =='3' || s.charAt(i) =='4' || s.charAt(i) =='5' || s.charAt(i) =='6' || s.charAt(i) =='7' || s.charAt(i) =='8' || s.charAt(i) =='9')) {
			i = i + 1;
		}
		return i;
	}
	
	public String saveCoeff(String s, int i) {
		String coef = "";
		while(s.charAt(i) =='0' || s.charAt(i) =='1' || s.charAt(i) =='2' || s.charAt(i) =='3' || s.charAt(i) =='4' || s.charAt(i) =='5' || s.charAt(i) =='6' || s.charAt(i) =='7' || s.charAt(i) =='8' || s.charAt(i) =='9' || s.charAt(i) =='.') {
			coef = coef + s.charAt(i);
			i = i + 1;
		}
		return coef;
	}
	
	public String savePower(String s, int i) {
		String power = "";
		while(i<s.length()&&(s.charAt(i) =='0' || s.charAt(i) =='1' || s.charAt(i) =='2' || s.charAt(i) =='3' || s.charAt(i) =='4' || s.charAt(i) =='5' || s.charAt(i) =='6' || s.charAt(i) =='7' || s.charAt(i) =='8' || s.charAt(i) =='9')) {
			power = power + s.charAt(i);
			i = i + 1;
		}
		return power;
	}
	
	public Monomial stringToMonomial(String s) {
		int i = 0; 
		int semn = 1; 			  
		if (s.charAt(0) == '-') {
			semn = -1; 
			i = i+1;
		}
		if (s.charAt(0) == '+') {
			i = i+1;
		}
		String coef = saveCoeff(s,i);
		i = parcurgereCoeff(s,i);
		boolean steluta =true;
		if (s.charAt(i) !='*' && s.charAt(i+1) !='x')
			steluta = false;
		if(steluta == true)
			i = i+3;
		else 
			i = i+2;
		String power = savePower(s,i);
		i=parcurgerePower(s,i);
		float coeff = Float.parseFloat(coef) * semn;
		int powerr = Integer.parseInt(power);
		Monomial m = new Monomial(coeff, powerr);
		return m;
	}
	
	public boolean validareText(String s) {
		int i = 0; 
		boolean ok = true;
		if (s.charAt(0) == '-') 
			i = i+1;		
		if (s.charAt(0) == '+') 
			i = i+1;	
		
		i = parcurgereCoeff(s,i);
		
		boolean steluta =true;
		if (s.charAt(i) != '*' && s.charAt(i+1) !='x')
			steluta = false;
		
		boolean variabila=true;
		if(s.charAt(i) != 'x' && s.charAt(i) != 'X' )
			variabila = false;
		
		if(variabila == false && steluta == false)
			ok = false;
		
		if(steluta == true)
			i = i+2;
		else 
			i = i+1;
		
		if(s.charAt(i) != '^')
			ok =false;
		i = i+1;
		
		i =  parcurgerePower(s,i);
		
		if(i < s.length())
			ok = false;
		return ok;
	}
	
}
