package domain;

import ui.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static util.LottoPrice.LOTTO_PRICE;

public class LottoOrderGroupStatics {
	private final List<Integer> winnerNumbers;
	private final List<Lotto> lottoOrderGroup;
	private final int bonusBall;
	private Integer match3 = 0;
	private Integer match4 = 0;
	private Integer match5 = 0;
	private Integer match5_bonus = 0;
	private Integer match6 = 0;

	public LottoOrderGroupStatics (List<Integer> winnerNumbers, int bonusBall, List<Lotto> lottoOrderGroup) {
		this.winnerNumbers = winnerNumbers;
		this.lottoOrderGroup = lottoOrderGroup;
		this.bonusBall = bonusBall;
	}

	public void matchSetting () {
		for (Lotto lotto : lottoOrderGroup) {
			final Integer matchCount = LottoNumberMatch.matchCount(winnerNumbers, lotto);
			match(matchCount, LottoNumberMatch.matchBonus(bonusBall, lotto));
		}
	}

	private void match (Integer matchCount, Boolean bonusMatch) {
		if (matchCount == 3) {
			match3++;
		}
		if (matchCount == 4) {
			match4++;
		}
		if (matchCount == 5) {
			checkBonus(bonusMatch);
		}
		if (matchCount == 6) {
			match6++;
		}
	}

	private void checkBonus (Boolean bonusMatch) {
		if (bonusMatch) {
			match5_bonus++;
			return;
		}
		match5++;
	}

	public String yield () {
		final BigDecimal lottoAmount = new BigDecimal(lottoOrderGroup.size());

		final BigDecimal rewards = new BigDecimal(
				(match3 * Rank.FIFTH.money())
						+ (match5_bonus * Rank.SECOND_BONUS.money())
						+ (match4 * Rank.THIRD.money())
						+ (match5 * Rank.SECOND.money())
						+ (match6 * Rank.FIRST.money())
		);

		if (rewards.compareTo(new BigDecimal(0)) == 0) {
			return "0";
		}

		return rewards.divide(lottoAmount.multiply(new BigDecimal(LOTTO_PRICE)), 2, RoundingMode.HALF_EVEN).toString();
	}

	public Integer match3 () {
		return match3;
	}

	public Integer match4 () {
		return match4;
	}

	public Integer match5 () {
		return match5;
	}

	public Integer match5_bonus () {
		return match5_bonus;
	}

	public Integer match6 () {
		return match6;
	}
}
