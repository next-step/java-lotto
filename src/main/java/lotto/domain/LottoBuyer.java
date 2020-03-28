package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuyer {
	private static final int PRIZE = 1000;

	private final List<Integer> candidateNumbers = IntStream.range(1, 46)
			.boxed()
			.collect(Collectors.toList());

	public List<LottoNumber> buyLottoNumbers(int money) {
		int count = money / PRIZE;
		return getLottoNumbers(count);
	}

	private List<LottoNumber> getLottoNumbers(int count) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Collections.shuffle(candidateNumbers);
			lottoNumbers.add(new LottoNumber(candidateNumbers.subList(0, 6)));
		}

		return lottoNumbers;
	}

}
