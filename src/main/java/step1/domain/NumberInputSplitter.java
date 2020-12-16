package step1.domain;

import java.util.Arrays;

public abstract class NumberInputSplitter implements InputSplitter {

	@Override
	public int[] split(final String input) {
		final String[] numbers = doSplit(input);
		return convert(numbers);
	}

	private int[] convert(final String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
	}

	protected abstract String[] doSplit(final String input);

}
