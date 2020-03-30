package lotto.domain;

import lotto.domain.dto.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuyer {
	private static final int PRIZE = 1000;

	private final List<Integer> candidateNumbers = IntStream.rangeClosed(LottoNumber.LOWEST_NUMBER, LottoNumber.HIGHEST_NUMBER)
			.boxed()
			.collect(Collectors.toList());

	public List<LottoNumbers> buyLottoNumbers(long money) {
		long count = money / PRIZE;
		return getLottoNumbers((int) count);
	}

	private List<LottoNumbers> getLottoNumbers(int count) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			Collections.shuffle(candidateNumbers);
			lottoNumbers.add(new LottoNumber(new ArrayList<>(candidateNumbers.subList(0, LottoNumber.NUMBER_SIZE))).getLottoNumbers());
		}

		return lottoNumbers;
	}

}
