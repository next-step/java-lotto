package step2.controller;

import step2.domain.LottoMachine;
import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;
import step2.domain.LottoPrice;
import step2.domain.LottoProfit;
import step2.domain.LottoPurchase;
import step2.domain.LottoResults;
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
		LottoPurchase lottoPurchase = new LottoPurchase(lottoPrice, inputView.inputManualLottoNumbers());
		Lottos lottos = LottoMachine.issue(lottoPurchase);
		outputView.printLottoCount(lottoPurchase);
		outputView.printLottos(lottos.getLottos());

		LottoNumbers winLottoNumbers = inputView.inputWinNumbers();
		LottoNumber bonusNumber = inputView.inputBonusNumber();

		LottoResults lottoResults = new LottoResults(lottos, winLottoNumbers, bonusNumber);

		outputView.printWinResult(lottoResults);
		outputView.printProfitRatio(new LottoProfit(lottoPrice, lottoResults));

	}

}
