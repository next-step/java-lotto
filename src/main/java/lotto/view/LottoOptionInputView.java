package lotto.view;

import lotto.number.WinningNumbers;
import lotto.option.LottoBuyPlan;
import lotto.option.LottoOption;
import lotto.view.input.MoneyInputView;
import lotto.view.input.WinningNumberInputView;

public class LottoOptionInputView implements LottoOption {

	private final MoneyInputView moneyInputView;
	private final WinningNumberInputView winningNumberInputView;

	public LottoOptionInputView() {
		this.moneyInputView = new MoneyInputView();
		this.winningNumberInputView = new WinningNumberInputView();
	}

	@Override
	public LottoBuyPlan getBuyPlan() {
		// TODO :
		throw new UnsupportedOperationException("공사중");
	}

	@Override
	public WinningNumbers getWinningNumbers() {
		return this.winningNumberInputView.getWinningNumbers();
	}
}
