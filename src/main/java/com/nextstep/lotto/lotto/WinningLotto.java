package com.nextstep.lotto.lotto;

import java.util.HashSet;
import java.util.Set;

import com.nextstep.lotto.result.LottoRank;

public class WinningLotto {
	private final Set<LottoNumber> numbers;

	public WinningLotto(Set<LottoNumber> numbers) {
		this.numbers = new HashSet<>(numbers);
		if (this.numbers.size() != Lotto.LOTTO_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	public LottoRank matchRank(Lotto lotto) {
		return LottoRank.valueOf(lotto.matchCount(numbers));
	}
}
