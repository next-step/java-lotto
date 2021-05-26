package lotto;

import lotto.exceptions.DuplicationNotAllowedException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
	private static final int TWO_LOTTO_NUMBERS_LENGTH = Constants.LOTTO_NUMBERS_LENGTH * 2;

	private final List<Integer> winningNumber;
	private final Integer bonusNumber;

	private WinningNumber(List<Integer> winningNumber, Integer bonusNumber) {
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}

	public static WinningNumber of(List<Integer> winningNumber, Integer bonusNumber) {
		if (winningNumber.contains(bonusNumber)) {
			throw new DuplicationNotAllowedException();
		}
		return new WinningNumber(winningNumber, bonusNumber);
	}

	public LottoPrizeType checkWinning(List<Integer> lottoNumbers) {
		Set<Integer> set = new HashSet<>(winningNumber);
		set.addAll(lottoNumbers);
		return LottoPrizeType.valueByMatchedNumberCount(
				TWO_LOTTO_NUMBERS_LENGTH - set.size(),
				isBonusBallMatched(lottoNumbers));
	}

	private boolean isBonusBallMatched(List<Integer> lottoNumbers) {
		return lottoNumbers.contains(bonusNumber);
	}
}
