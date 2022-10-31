package step2.controller;

import step2.model.LottoChecker;
import step2.model.Lottos;
import step2.model.Money;
import step2.util.FixLottoGenerator;
import step2.util.LottoGenerator;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.Map;

public class LottoController {

	private final Lottos lottos;
	private final LottoChecker lottoChecker;
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public LottoController(LottoGenerator lottoGenerator) {
		Money money = new Money(inputView.inputMoney());
		lottos = new Lottos(money, lottoGenerator);
		lottoChecker = new LottoChecker(lottos, money);
	}

	public void buyLotto() {
		outputView.printTicketCnt(lottos.getTicketCnt());
		outputView.printLottoNumbers(lottos.getLottos());
		Map<Integer, Integer> hitCntMap =
				lottoChecker
						.checkHit(
								new FixLottoGenerator(inputView.inputLastWeekNumber()
										.replaceAll(" ", ""))
										.generating());
		double earningRate = lottoChecker.getEarningRate(hitCntMap);
		outputView.pritnHitStatistics(hitCntMap, earningRate);
	}
}
