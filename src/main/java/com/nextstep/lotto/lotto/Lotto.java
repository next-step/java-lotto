package com.nextstep.lotto.lotto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {

	public static final int LOTTO_SIZE = 6;
	private static final String LOTTO_NUMBER_CAN_ONLY_6_DIGITS = "로또의 숫자는 6개만 가능합니다.";
	private final Set<LottoNumber> numbers;

	public Lotto(Set<LottoNumber> lottoNumbers) {
		this.numbers = new HashSet<>(lottoNumbers);
		if (this.numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_CAN_ONLY_6_DIGITS);
		}
	}

	public int match(Lotto winningLotto) {
		return Math.toIntExact(numbers.stream()
			.filter(winningLotto.numbers::contains)
			.count());
	}

	public Set<LottoNumber> numbers() {
		return numbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
