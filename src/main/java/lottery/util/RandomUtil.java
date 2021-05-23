package lottery.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtil {

	public static List<Integer> generateSixNumbers(final int startInclusive, final int endInclusive) {
		List<Integer> numbers = new ArrayList<>();
		IntStream.range(startInclusive, endInclusive)
			.forEach(numbers::add);

		Collections.shuffle(numbers);
		return numbers.subList(0, 6).stream()
			.sorted()
			.collect(Collectors.toList());
	}
}
