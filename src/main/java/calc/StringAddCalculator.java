package calc;

public class StringAddCalculator {

	public static int splitAndSum(String str) {
		String[] tokens = StringSplitter.split(str);
		Number result = new Number();

		for(String s : tokens){
			result = result.add(new Number(s));
		}

		return result.getNumber();
	}
}
