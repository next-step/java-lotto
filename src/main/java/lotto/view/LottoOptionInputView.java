package lotto.view;

import lotto.number.WinningNumbers;
import lotto.option.LottoBuyPlan;
import lotto.option.LottoOption;
import lotto.view.input.LottoBuyPlanInputView;
import lotto.view.input.WinningNumberInputView;

public class LottoOptionInputView implements LottoOption {

	private final LottoBuyPlanInputView lottoBuyPlanInputView;
	private final WinningNumberInputView winningNumberInputView;

	public LottoOptionInputView() {
		this.lottoBuyPlanInputView = new LottoBuyPlanInputView();
		this.winningNumberInputView = new WinningNumberInputView();
	}

	@Override
	public LottoBuyPlan getBuyPlan() {
		return lottoBuyPlanInputView.inputLottoBuyPlan();
	}

	@Override
	public WinningNumbers getWinningNumbers() {
		return this.winningNumberInputView.getWinningNumbers();
	}
}
