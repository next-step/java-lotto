package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements LottoNumbersGenerateStrategy {
	private static final Random random = new Random();

	@Override
	public List<LottoNumbers> generate(int count) {
		return IntStream.range(0, count)
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
