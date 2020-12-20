package step2.controller;

import step2.domain.LottoPrice;
import step2.view.InputView;

public class LottoRunner {

	private final InputView inputView;

	public LottoRunner() {
		this.inputView = new InputView();
	}

	public void start() {
		LottoPrice lottoPrice = new LottoPrice(inputView.inputPurchasePrice());
	}

}
