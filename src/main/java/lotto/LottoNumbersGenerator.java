package lotto;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {
	private static final int FROM_ZERO = 0;
	private static final int ONE_FOR_EXCLUSIVE = 1;

	public List<LottoNumbers> generateRandomly(int count, Random random) {
		return IntStream.range(FROM_ZERO, count)
			.mapToObj((i) -> new LottoNumbers(generateRandomNumbers(random)))
			.collect(Collectors.toList());
	}

	private List<Integer> generateRandomNumbers(Random random) {
		List<Integer> candidateNumbers = generateLottoCandidateNumbers();
		Collections.shuffle(candidateNumbers, random);
		return candidateNumbers.subList(FROM_ZERO, LottoNumbers.LENGTH);
	}

	private List<Integer> generateLottoCandidateNumbers() {
		return IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + ONE_FOR_EXCLUSIVE)
			.boxed()
			.collect(toList());
	}
}
