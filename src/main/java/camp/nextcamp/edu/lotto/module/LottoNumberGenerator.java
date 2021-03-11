package camp.nextcamp.edu.lotto.module;

import static camp.nextcamp.edu.lotto.constants.LottoConstants.*;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextcamp.edu.lotto.entity.LottoNumber;

public class LottoNumberGenerator {
	private static final Map<Integer, LottoNumber> numbers;

	private LottoNumberGenerator() {
	}

	static {
		numbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
			.boxed()
			.collect(Collectors.toMap(i -> i, LottoNumber::new));
	}

	public static LottoNumber generate(int number) {
		return numbers.get(number);
	}

	public static Set<LottoNumber> generateRandomNumber(Random random) {
		return random.ints(LOTTO_MIN, LOTTO_MAX)
			.distinct()
			.limit(LOTTO_COUNT)
			.mapToObj(LottoNumberGenerator::generate)
			.collect(Collectors.toCollection(TreeSet::new));
	}
}
