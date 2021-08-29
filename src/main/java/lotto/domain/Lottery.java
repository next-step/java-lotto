package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.type.WinningType;

public class Lottery {
	private final Numbers winningNumbers;
	private final Number bonusNumber;

	public Lottery(Numbers winningNumbers, Number bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public LotteryResults draw(Lottos lottos) {
		List<LotteryResult> results = new ArrayList<>();
		for (Lotto lotto : lottos.getLottos()) {
			WinningType winningType = getDrawResult(lotto.getNumbers());
			results.add(new LotteryResult(winningType));
		}
		return new LotteryResults(results);
	}

	private WinningType getDrawResult(Numbers lottoNumbers) {
		int matchNumber = lottoNumbers.matchSize(winningNumbers);
		int bonusNumberValue = bonusNumber.getValue();
		boolean matchBonus = lottoNumbers.containsNumber(bonusNumberValue);
		return WinningType.getWinningType(matchNumber, matchBonus);
	}
}
