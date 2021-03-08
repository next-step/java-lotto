package camp.nextcamp.edu.calculator.module;

import java.util.Arrays;
import java.util.List;

public class DefaultPatternStringTokenizer extends PatternStringTokenizer {

	public DefaultPatternStringTokenizer() {
		super(",|:");
	}

	@Override
	public List<String> makeListByPatternSplit(String input) {
		return Arrays.asList(input.split(super.getRegex()));
	}
}
