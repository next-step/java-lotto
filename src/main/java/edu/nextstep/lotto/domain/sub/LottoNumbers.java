package edu.nextstep.lotto.domain.sub;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static final int SIZE = 6;

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<Integer> numbers) {
		if (!isValid(numbers)) {
			throw new IllegalArgumentException("올바르지 않은 로또 번호입니다.");
		}
		this.lottoNumbers = numbers.stream()
			.map(LottoNumber::of)
			.collect(Collectors.toList());
	}

	public static boolean isValid(List<Integer> numbers) {
		return new HashSet<>(numbers).size() == SIZE
			&& numbers.stream().allMatch(LottoNumber::isValid);
	}

	public int countBySame(LottoNumbers other) {
		return (int)lottoNumbers.stream()
			.filter(other.lottoNumbers::contains)
			.count();
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}
}