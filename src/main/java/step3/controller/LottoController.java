package step3.controller;


import step3.model.LottoChecker;
import step3.model.LottoList;
import step3.model.Money;
import step3.model.WinnerLotto;
import step3.util.LottoGenerator;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

		Map<Integer, Integer> hitMap = IntStream.range(0, 6)
				.boxed()
				.collect(Collectors.toMap(i -> i, i -> 0, (a, b) -> b));

		lottoList.getLottoList().stream()
				.mapToInt(lottoChecker::match)
				.filter(hitMap::containsKey)
				.forEachOrdered(awardRank -> hitMap.put(awardRank, hitMap.get(awardRank) + 1));

		outputView.printHitStatistics(hitMap, LottoChecker.getEarningRate(hitMap, money));
	}


}
