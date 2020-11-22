package nextstep.step2.domain;

import java.util.stream.Stream;

public enum LottoReward {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	LOST(0, 0); //2개 이하로 맞으면 0원

	private final int countOfMatch;
	private final int winningMoney;

	LottoReward(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static LottoReward getReword(int countOfMatch, boolean hasBonusNumber) {
		LottoReward lottoReward = Stream.of(values())
				.filter(reward -> reward.countOfMatch == countOfMatch)
				.findFirst()
				.orElse(LOST);
		return findLottoRewardByBonus(lottoReward, hasBonusNumber);
	}

	protected static LottoReward findLottoRewardByBonus(LottoReward lottoReward, boolean hasBonusNumber) {
		if ((lottoReward == LottoReward.SECOND) && !hasBonusNumber) {
			return LottoReward.THIRD;
		}
		return lottoReward;
	}
}
