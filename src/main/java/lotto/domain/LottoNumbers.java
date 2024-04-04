package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.strategy.LottoNumberStrategy.*;

public class LottoNumbers {
	private final List<Integer> lottoNumbers;

	public LottoNumbers(List<Integer> lottoNumbers) {
		if(new HashSet<>(lottoNumbers).size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("번호는 중복될 수 없습니다.");
		}

		if(lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("번호는 " + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
		}

		if(lottoNumbers.stream().anyMatch(x -> x < LOTTO_NUMBER_MIN || x > LOTTO_NUMBER_MAX)) {
			throw new IllegalArgumentException("번호는 " + LOTTO_NUMBER_MIN + " 미만 " + LOTTO_NUMBER_MAX + " 초과인 수를 입력할 수 없습니다.");
		}

		this.lottoNumbers = lottoNumbers.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean isMatched(int number) {
		return lottoNumbers.contains(number);
	}
}
