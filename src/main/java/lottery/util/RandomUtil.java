package lottery.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lottery.LottoNo;

public class RandomUtil {

	public static Set<LottoNo> generateSixLottoNoes(final int startInclusive, final int endInclusive) {
		List<Integer> numbers = new ArrayList<>();
		IntStream.range(startInclusive, endInclusive)
			.forEach(numbers::add);

		Collections.shuffle(numbers);
		return numbers.stream()
			.limit(6)
			.sorted()
			.map(LottoNo::of)
			.collect(Collectors.toCollection(LinkedHashSet::new));
	}
}
