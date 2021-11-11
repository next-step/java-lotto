package lotto.generator;

import java.util.Arrays;
import java.util.List;

public class FixedGenerator implements Generator {
	public static final List<Integer> FIXED_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);

	@Override
	public List<Integer> generate() {
		return FIXED_NUMBERS;
	}
}
