package study;

public abstract class StringAddSplitter {

	protected String stringNumbers;
	protected String[] tokens;

	public StringAddSplitter(String stringNumbers) {
		this.stringNumbers = stringNumbers;
	}

	public abstract void split();

	public static StringAddSplitter createCustomSplitter(String stringNumbers) {
		return new StringAddCustomSplitter(stringNumbers);
	}

	public static StringAddSplitter createDefaultSplitter(String stringNumbers) {
		return new StringAddDefaultSplitter(stringNumbers);
	}

	public String[] getTokens() {
		return this.tokens;
	}

	protected void validTokens() throws RuntimeException {
		for (String token : this.tokens)
			negativeValidToken(token);
	}

	private void negativeValidToken(String token) {
		if (Integer.parseInt(token) < 0)
			throw new RuntimeException("음수입니다.");
	}

}
