package lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

import java.util.List;

import lotto.controller.LottoGame;
import lotto.domain.LotteryResults;
import lotto.domain.Lottos;
import lotto.domain.Wallet;

public class LottoApplication {
	public static void main(String[] args) {
		Wallet wallet = new Wallet(inputMoney());
		final int countLottoByManual = inputCountLottoByManual();
		List<String> lottoNumbersByManual = inputLottoNumbersByManual(countLottoByManual);

		Lottos lottoByManual = wallet.buyLottoByManual(lottoNumbersByManual);
		Lottos lottoByAuto = wallet.buyLottoByAuto();
		outputBuyLotto(lottoByManual, lottoByAuto);
		lottoByManual.addLottos(lottoByAuto);

		LottoGame lottoGame = new LottoGame();
		LotteryResults results = lottoGame.draw(lottoByManual, inputWinningNumbers());
		outputWinningStatistics(results);
	}
}