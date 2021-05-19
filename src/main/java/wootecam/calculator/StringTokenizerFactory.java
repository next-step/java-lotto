package wootecam.calculator;

public class StringTokenizerFactory {
	
	public static StringTokenizer getStringTokenizer(String input) {
		if (input.startsWith("//")) {
			return new CustomStringTokenizer();
		}
		return new DefaultStringTokenizer();
	}
}
