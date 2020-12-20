package step2.controller;

import step2.domain.LottoPrice;
import step2.domain.Lottos;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoRunner {

	private final InputView inputView;
	private final OutputView outputView;

	public LottoRunner() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		LottoPrice lottoPrice = new LottoPrice(inputView.inputPurchasePrice());
		Lottos lottos = new Lottos(lottoPrice);
		outputView.printLottos(lottos.getLottos());
	}

}
