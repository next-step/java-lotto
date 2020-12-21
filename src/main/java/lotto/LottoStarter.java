package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoNumbers;
import lotto.dto.LottoGameResultDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStarter {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();

		int buyMoney = InputView.inputBuyMoneyAndReturnInputValue();
		int lottoGameCount = lottoGame.calculateLottoCount(buyMoney);
		ResultView.printLottoGameCount(lottoGameCount);

		LottoNumbers lottoNumbers = lottoGame.generateLottoNumbers(lottoGameCount, new LottoNumberGenerator());
		ResultView.printLottoNumbers(lottoNumbers);

		LottoNumber winLottoNumber = new LottoNumber(InputView.inputWinLottoNumbersAndReturnInputValue());
		LottoGameResultDto lottoGameResultDto = lottoGame.generateLottoGameResult(winLottoNumber, lottoNumbers);
		ResultView.printLottoGameStatistic(lottoGameResultDto);
		ResultView.printProfitRatio(lottoGameResultDto);
	}
}
