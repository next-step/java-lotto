package step3.controller;

import java.util.stream.Collectors;

import step3.model.Amount;
import step3.model.lotto.Lotto;
import step3.model.lotto.Lottos;
import step3.model.winning.WinningResult;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	private Lottos manualLottos;
	private Lottos automaticLottos;
	private Lotto winningLotto;
	private WinningResult winningResult;
	private Amount amount;
	private int bonusNumber;

	public void purchase() {
		amount = new Amount(inputView.getPurchaseAmount(), inputView.getManualLottoCount());

		manualLottos = new Lottos(inputView.getManualLottos(amount.getManualCount()).stream().map(Lotto::new).collect(Collectors.toList()));

		automaticLottos = new Lottos(amount.getAutomaticCount());
		outputView.printLottoCount(amount);
		outputView.printLottos(manualLottos);
		outputView.printLottos(automaticLottos);
	}

	public void getWinningNumber() {
		winningLotto = new Lotto(inputView.getWinningNumber());
	}

	public void getBonusNumber() {
		bonusNumber = inputView.getBonusNumber();
	}

	public void getWinningStatistics() {
		outputView.printWinningStatisticsHeader();
		winningResult = new WinningResult(bonusNumber, winningLotto, manualLottos, automaticLottos);

		outputView.printWinningStatistics(winningResult.getCountMap());
		outputView.printYield(amount.getYield(winningResult.calculatePrize()));
	}
}
