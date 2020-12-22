package lotto.option;

import lotto.number.WinningNumbers;

public interface LottoOption {
	LottoBuyPlan getBuyPlan();
	WinningNumbers getWinningNumbers();
}
