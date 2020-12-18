package step1.domain;

public class CommaColonInputSplitter extends NumberInputSplitter {

	@Override
	protected String[] doSplit(final String input) {
		final String COMMA_OR_COLON_SPLITTER = "[,:]";
		return input.split(COMMA_OR_COLON_SPLITTER);
	}

}
