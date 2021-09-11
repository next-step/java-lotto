package lotto;

import java.util.List;

public class WinningNumber {
	private final Lotto lotto;
	private final LottoNumber bonusNumber;

	public WinningNumber(List<Integer> numbers, int bonusNumber) {
		this.lotto = new Lotto(numbers);
		this.bonusNumber = new LottoNumber(bonusNumber);
	}

	public Lotto unmaskedLotto(Lotto maskedLotto) {
		LottoRank rank = LottoRank.findLottoRank(maskedLotto.matchNumber(this.lotto),
			maskedLotto.contains(this.bonusNumber));
		return maskedLotto.copyWithoutRank(rank);
	}
}
