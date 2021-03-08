package camp.nextcamp.edu.calculator.module;

public class PatternTokenizerFactory {

	public static PatternStringTokenizer getTokenizer(String input) {
		if (input.startsWith("//")) {
			return new CustomPatternTokenizer();
		}
		return new DefaultPatternStringTokenizer();
	}
}
