package com.nextstep.lotto.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nextstep.lotto.result.LottoRank;

public class WinningLotto {
	private final Set<LottoNumber> numbers;

	public WinningLotto(List<LottoNumber> numbers) {
		if (numbers.size() != Lotto.LOTTO_SIZE) {
			throw new IllegalArgumentException();
		}
		this.numbers = new HashSet<>(numbers);
	}

	public LottoRank matchRank(Lotto lotto) {
		return LottoRank.match(lotto.matchCount(numbers));
	}
}
