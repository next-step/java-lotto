package step1.iksoo.StringAddCalculator;

public class StringAddMain {
	static StringAddCalculator stringAddCalculator = new StringAddCalculator();
	
	public static void main(String[] args) throws Exception {
		int addResult = stringAddCalculator.add("8,-1");
		Output.printTextln(addResult);
	}
}
