package camp.nextcamp.edu.lotto.entity;

import java.util.Set;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.module.WinningScore;

public class WinningLotto {
	private final Lotto lotto;
	private final BonusNumber bonusNumber;

	public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
		this.lotto = lotto;
		this.bonusNumber = new BonusNumber(bonusNumber, this);
	}

	public Lotto getLotto() {
		return lotto;
	}

	private int getIntersectionCount(Set<LottoNumber> input) {
		return input.stream()
			.filter(this.lotto.getNumbers()::contains)
			.collect(Collectors.toSet())
			.size();
	}

	public WinningScore getWinningScore(Lotto input) {
		int intersectionCount = getIntersectionCount(input.getNumbers());

		boolean matchBonus = input.getNumbers().contains(this.bonusNumber.getLottoNumber());
		return WinningScore.getInstance(intersectionCount, matchBonus);
	}

}
