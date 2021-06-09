package com.nextstep.lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Lotto {

	public static final int LOTTO_SIZE = 6;
	private static final String LOTTO_NUMBER_CAN_ONLY_6_DIGITS = "로또의 숫자는 6개만 가능합니다.";
	public static final String BONUS_NUMBER_DO_NOT_ALLOWED_DUPLICATE = "보너스 볼은 로또 번호 6개와 달라야 합니다.";
	public static final String DELIMITER = ", ";

	private final Set<LottoNumber> numbers;
	private final LottoNumber bonusNumber;

	public Lotto(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
		if (lottoNumbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_CAN_ONLY_6_DIGITS);
		}
		if (lottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(BONUS_NUMBER_DO_NOT_ALLOWED_DUPLICATE);
		}
		this.numbers = new HashSet<>(lottoNumbers);
		this.bonusNumber = bonusNumber;

	}

	public int match(Lotto winningLotto) {
		return Math.toIntExact(numbers.stream()
			.filter(winningLotto.numbers::contains)
			.count());
	}

	public boolean isBonusNumberMatch(LottoNumber bonusNumber) {
		return bonusNumber.equals(bonusNumber);
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

	@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner(DELIMITER);
		List<LottoNumber> lottoNumbers = new ArrayList<>(numbers);
		Collections.sort(lottoNumbers);

		for (LottoNumber lottoNumber : lottoNumbers) {
			stringJoiner.add(String.valueOf(lottoNumber));
		}
		return "[ " + stringJoiner + " ( " + bonusNumber + " )" + " ]";
	}
}
