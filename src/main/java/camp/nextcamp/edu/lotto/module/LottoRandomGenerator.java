package camp.nextcamp.edu.lotto.module;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoRandomGenerator {
	private static final int MIN = 1;
	private static final int MAX = 46;
	private static final int LOTTO_COUNT = 6;

	public static List<Integer> generate(Random random) {
		return random.ints(MIN, MAX)
			.distinct()
			.limit(LOTTO_COUNT)
			.boxed()
			.collect(Collectors.toList());
	}
}
