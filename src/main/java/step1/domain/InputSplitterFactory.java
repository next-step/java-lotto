package step1.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum InputSplitterFactory {

	COMMA_SPLITTER(Pattern.compile("([\\d]|[,\\d])*"), new CommaInputSplitter()),
	COLON_SPLITTER(Pattern.compile("([\\d]|[:\\d])*"), new ColonInputSplitter()),
	COMMA_COLON_SPLITTER(Pattern.compile("([\\d]|[,|:\\d])*"), new CommaColonInputSplitter());

	private final Pattern pattern;
	private final InputSplitter inputSplitter;

	InputSplitterFactory(final Pattern pattern, final InputSplitter inputSplitter) {
		this.pattern = pattern;
		this.inputSplitter = inputSplitter;
	}

	public InputSplitter getInputSplitter() {
		return inputSplitter;
	}

	public static InputSplitter of(final String input) {
		return Arrays.stream(InputSplitterFactory.values())
			.filter(inputSplitterFactory -> inputSplitterFactory.pattern.matcher(input).matches())
			.findFirst()
			.orElseThrow(RuntimeException::new)
			.inputSplitter;
	}

}
