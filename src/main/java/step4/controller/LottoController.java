package step4.controller;


import step4.model.*;
import step4.util.LottoGenerator;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
	private final LottoGenerator lottoGenerator;

	public LottoController(LottoGenerator lottoGenerator) {
		this.lottoGenerator = lottoGenerator;
	}

	public void game() {
		Money money = new Money(InputView.inputPurchaseAmount());
		List<String> manualLottoNum = InputView.inputManualLottoNum(InputView.inputPurchaseManualLottoCnt());
		OutputView.printTicketCnt(manualLottoNum.size(), money.getLottoTicketCnt() - manualLottoNum.size());

		LottoList lottoList = new LottoList(money, lottoGenerator, manualLottoNum);
		OutputView.printLottoNumbers(lottoList);

		WinnerLotto winnerLotto = new WinnerLotto(InputView.inputLaskWeekWinnerNumber(), InputView.inputBonusBall());
		LottoChecker lottoChecker = new LottoChecker(winnerLotto);
		Map<Integer, Integer> hitMap = lottoChecker.checkHitCnt(lottoList);
		OutputView.printHitStatistics(hitMap, RateChecker.getEarningRate(hitMap, money));
	}

}
