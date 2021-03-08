package camp.nextcamp.edu.calculator.module;

import java.util.List;

public abstract class PatternStringTokenizer {
	private final String regex;

	PatternStringTokenizer(String regex) {
		this.regex = regex;
	}

	public abstract List<String> makeListByPatternSplit(String input);

	protected String getRegex() {
		return this.regex;
	}
}
