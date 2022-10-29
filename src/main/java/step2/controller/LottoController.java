package step2.controller;

import step2.model.Lottos;
import step2.util.LottoGenerator;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {
	private final static String DELIMITER = ", ";

	private final Lottos lottos;
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public LottoController(LottoGenerator lottoGenerator) {
		lottos = new Lottos(inputView.inputMoney(), lottoGenerator);
	}

	public void buyLotto() {
		outputView.printTicketCnt(lottos.getTicketCnt());
		outputView.printLottoNumbers(lottos.getLottos());
		Map<Integer, Integer> hitCntMap =
				lottos.checkHit(
					Arrays.stream(inputView.inputLastWeekNumber().split(DELIMITER))
						.mapToInt(Integer::parseInt)
						.boxed()
						.collect(Collectors.toList()));
		Double earningRate = lottos.getEarningRate(hitCntMap);
		outputView.pritnHitStatistics(hitCntMap, earningRate);
	}
}
