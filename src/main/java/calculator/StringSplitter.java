package calculator;

class StringSplitter {

	private final Delimiter delimiter;

	StringSplitter(String delimiterText) {
		this.delimiter = new Delimiter(delimiterText);
	}

	String[] split(String text) {
		if (text == null) {
			return new String[]{};
		}

		return text.split(delimiter.get());
	}

}
