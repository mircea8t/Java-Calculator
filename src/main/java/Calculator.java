
public class Calculator {
	public static void main(String[] args) {
		Fereastra calc = new Fereastra();
		Operations calcOperations = new Operations();
		Control ctrl = new Control(calc, calcOperations);
		calc.setVisible(true);
	}

}
