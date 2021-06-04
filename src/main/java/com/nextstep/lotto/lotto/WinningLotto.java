package com.nextstep.lotto.lotto;

import java.util.List;

import com.nextstep.lotto.result.LottoRank;

public class WinningLotto {
	private final List<LottoNumber> numbers;

	public WinningLotto(List<LottoNumber> numbers) {
		this.numbers = numbers;
	}

	public LottoRank matchRank(Lotto lotto) {
		return LottoRank.match(lotto.matchCount(numbers));
	}
}
