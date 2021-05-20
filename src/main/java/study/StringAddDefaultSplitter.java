package study;

public class StringAddDefaultSplitter extends StringAddSplitter {

	private final static String DEFAULT_DELIMITER = ",|:";

	public StringAddDefaultSplitter(String stringNumbers) {
		super(stringNumbers);
	}

	@Override
	public void split() {
		this.tokens = stringNumbers.split(DEFAULT_DELIMITER);
		validateTokens();
	}
}
