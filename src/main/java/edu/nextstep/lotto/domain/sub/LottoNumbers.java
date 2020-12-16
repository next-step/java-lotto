package edu.nextstep.lotto.domain.sub;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static final int SIZE = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<Integer> numbers) {
		if (numbers.size() != SIZE) {
			throw new IllegalArgumentException("로또 번호의 개수는 " + SIZE + "개만 가능합니다.");
		}
		if (new HashSet<>(numbers).size() != SIZE) {
			throw new IllegalArgumentException("로또 번호는 중복되게 선택이 불가능합니다.");
		}
		this.lottoNumbers = numbers.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	public int countBySame(LottoNumbers other) {
		return (int)lottoNumbers.stream()
			.filter(other.lottoNumbers::contains)
			.count();
	}
}