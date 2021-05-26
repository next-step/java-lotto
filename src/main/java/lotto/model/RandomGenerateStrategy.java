package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements LottoNumbersGenerateStrategy {
	private static final Random random = new Random();
	private static final int FROM_ZERO = 0;
	private final int lottoCount;

	public RandomGenerateStrategy(int lottoCount) {
		this.lottoCount = lottoCount;
	}

	@Override
	public List<LottoNumbers> generate() {
		return IntStream.range(FROM_ZERO, lottoCount)
			.mapToObj((i) -> LottoNumbers.of(generateRandomNumbers()))
			.collect(Collectors.toList());
	}

	private List<Integer> generateRandomNumbers() {
		List<Integer> candidateNumbers = generateLottoCandidateNumbers();
		Collections.shuffle(candidateNumbers, random);
		return candidateNumbers.subList(0, LottoNumbers.LENGTH);
	}

	private List<Integer> generateLottoCandidateNumbers() {
		return IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
			.boxed()
			.collect(toList());
	}
}
