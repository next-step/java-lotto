package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumbersGenerator {
	private static final int FROM_ZERO = 0;
	private static final Random random = new Random();

	private LottoNumbersGenerator() {
	}

	public static List<LottoNumbers> generateRandomly(int count) {
		return IntStream.range(FROM_ZERO, count)
			.mapToObj((i) -> new LottoNumbers(generateRandomNumbers()))
			.collect(Collectors.toList());
	}

	private static List<Integer> generateRandomNumbers() {
		List<Integer> candidateNumbers = generateLottoCandidateNumbers();
		Collections.shuffle(candidateNumbers, random);
		return candidateNumbers.subList(FROM_ZERO, LottoNumbers.LENGTH);
	}

	private static List<Integer> generateLottoCandidateNumbers() {
		return IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
			.boxed()
			.collect(toList());
	}
}
