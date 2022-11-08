package step3.controller;


import step3.model.*;
import step3.util.LottoGenerator;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.Map;

public class LottoController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final LottoGenerator lottoGenerator;

	public LottoController(LottoGenerator lottoGenerator) {
		this.lottoGenerator = lottoGenerator;
	}

	public void game() {
		Money money = new Money(inputView.inputMoney());
		outputView.printTicketCnt(money.getLottoTicketCnt());
		LottoList lottoList = new LottoList(money, lottoGenerator);
		outputView.printLottoNumbers(lottoList);
		WinnerLotto winnerLotto = new WinnerLotto(inputView.inputWinnerNumber(), inputView.inputBonusNumber());
		LottoChecker lottoChecker = new LottoChecker(winnerLotto);
		Map<Integer, Integer> hitMap = lottoChecker.checkHitCnt(lottoList);

		outputView.printHitStatistics(hitMap, RateChecker.getEarningRate(hitMap, money));
	}


}
