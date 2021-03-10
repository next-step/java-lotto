package camp.nextcamp.edu.lotto.module;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.entity.LottoNumber;

public class LottoRandomGenerator {
	private static final int LOTTO_COUNT = 6;

	public static Set<LottoNumber> generate(Random random) {
		return random.ints(LOTTO_MIN, LOTTO_MAX)
			.distinct()
			.limit(LOTTO_COUNT)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toCollection(TreeSet::new));
	}
}
