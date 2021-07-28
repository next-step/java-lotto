package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	private static final int FIRST_NUMBER = 1;
	private static final int LAST_NUMBER = 45;
	public static final int INDEX_OF_1ST_NUMBER = 0;
	public static final int INDEX_OF_6TH_NUMBER = 6;
	private final List<Integer> numbers;

	public LottoMachine() {
		this.numbers = initializeNumbers();
	}

	public List<Integer> pickRandomNumbers() {
		Collections.shuffle(numbers);
		return IntStream.range(INDEX_OF_1ST_NUMBER, INDEX_OF_6TH_NUMBER)
				.mapToObj(numbers::get)
				.sorted()
				.collect(Collectors.toList());
	}

	private List<Integer> initializeNumbers() {
		return IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
				.boxed()
				.collect(Collectors.toList());
	}

}
