package lotto;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoUtils {

	public static final int LOTTO_PRICE = 1000;

	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_LIMIT_NUMBER = 46;

	private static final int REQUIRED_COUNT = 6;

	private static final List<Number> numberPool
		= IntStream.range(LOTTO_MIN_NUMBER, LOTTO_LIMIT_NUMBER)
			.mapToObj(Number::new)
			.collect(toList());

	public static List<Number> randomNumbers() {
		Collections.shuffle(numberPool);
		return numberPool.stream()
			.limit(REQUIRED_COUNT)
			.sorted()
			.collect(toList());
	}

	public static Map<Winner, Integer> defaultDashboard() {
		Map<Winner, Integer> dashboard = new HashMap<>();

		Arrays.stream(Winner.values()).forEach(winner -> {
			dashboard.put(winner, 0);
		});

		return dashboard;
	}
}
