package calculator;

public class StringNumber {

	private static final String DEFAULT_SEPARATOR = "[,:]";
	private static final String CUSTOM_SEPARATOR_PREFIX = "//";
	private static final String CUSTOM_SEPARATOR_SUFFIX = "\n";


	private String number;

	public StringNumber(String number) {
		if(isBlank(number)) {
			throw new IllegalArgumentException("잘못된 문자열입니다.");
		}
		this.number = number;
	}

	private boolean isBlank(String stringNumber) {
		return stringNumber == null || stringNumber.isEmpty();
	}

	public String[] getStringNumbers() {
		String separator = DEFAULT_SEPARATOR;
		if(hasCustomSeparator(CUSTOM_SEPARATOR_PREFIX)) {
			separator = getCustomSeparator(CUSTOM_SEPARATOR_PREFIX, CUSTOM_SEPARATOR_SUFFIX);
		}
		String removedCustomSeparator = getRemovedCustomSeparator(CUSTOM_SEPARATOR_SUFFIX);
		return removedCustomSeparator.split(separator);
	}

	public boolean hasCustomSeparator(String customSeparatorPrefix) {
		return number.startsWith(customSeparatorPrefix);
	}

	public String getCustomSeparator(String prefix, String suffix) {
		int prefixLastIndex = getAffixIndex(prefix) + prefix.length();
		int suffixBeginIndex = getAffixIndex(suffix);
		return number.substring(prefixLastIndex, suffixBeginIndex);
	}

	public String getRemovedCustomSeparator(String customSeparatorSuffix) {
		int numberBeginIndex = getAffixIndex(customSeparatorSuffix) + customSeparatorSuffix.length();
		return number.substring(numberBeginIndex);
	}

	private int getAffixIndex(String affix) {
		return number.indexOf(affix);
	}
}
