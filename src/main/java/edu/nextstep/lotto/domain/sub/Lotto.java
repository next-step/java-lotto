package edu.nextstep.lotto.domain.sub;

import java.util.List;
import java.util.Optional;

public class Lotto {
	public static final int PRICE = 1000;

	private final LottoNumbers lottoNumbers;

	public Lotto(List<Integer> numbers) {
		this.lottoNumbers = new LottoNumbers(numbers);
	}

	public Optional<LottoRank> getRank(Lotto winningLotto) {
		return LottoRank.from(lottoNumbers.countBySame(winningLotto.lottoNumbers));
	}
}