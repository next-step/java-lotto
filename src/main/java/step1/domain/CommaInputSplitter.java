package step1.domain;

public class CommaInputSplitter extends NumberInputSplitter {

	@Override
	protected String[] doSplit(final String input) {
		final String COMMA_DELIMITER = ",";
		return input.split(COMMA_DELIMITER);
	}

}
