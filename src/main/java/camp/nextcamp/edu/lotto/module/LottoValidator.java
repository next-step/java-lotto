package camp.nextcamp.edu.lotto.module;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidator {

	public static boolean isNotInRange(int number) {
		Set<Integer> ranges = IntStream.range(LOTTO_MIN, LOTTO_MAX)
			.boxed()
			.collect(Collectors.toSet());
		return ranges.contains(number);
	}
}
