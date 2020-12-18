package step1.domain;

public class ColonInputSplitter extends NumberInputSplitter {

	@Override
	protected String[] doSplit(final String input) {
		final String COLON_DELIMITER = ":";
		return input.split(COLON_DELIMITER);
	}

}
