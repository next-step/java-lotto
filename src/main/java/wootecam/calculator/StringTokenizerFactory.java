package wootecam.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringTokenizerFactory {

	private List<StringTokenizer> stringTokenizerList = new ArrayList<>();

	private static class LazyHolder {
		public static final StringTokenizerFactory stringTokenizerFactory = new StringTokenizerFactory();
	}

	public static StringTokenizerFactory getInstance() {
		return LazyHolder.stringTokenizerFactory;
	}

	private StringTokenizerFactory() {
		this.initStringTokenizerList();
	}

	private void initStringTokenizerList() {
		this.stringTokenizerList.add(new CustomStringTokenizer());
		this.stringTokenizerList.add(new DefaultStringTokenizer());
	}

	public StringTokenizer getStringTokenizer(String input) {
		return this.stringTokenizerList.stream()
			.filter(stringTokenizer -> stringTokenizer.supportForTokenizing(input))
			.findAny()
			.get();
	}
}
