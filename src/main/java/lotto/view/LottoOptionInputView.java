package lotto.view;

import lotto.LottoOption;
import lotto.number.WinningNumbers;
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
	public int getMoney() {
		return this.moneyInputView.getMoney();
	}

	@Override
	public WinningNumbers getWinningNumbers() {
		return this.winningNumberInputView.getWinningNumbers();
	}
}
