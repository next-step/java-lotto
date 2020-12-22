package lotto;

import lotto.domain.LottoGame;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTicket;
import lotto.dto.LottoGameResultDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStarter {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();

		int lottoGameCount = lottoGame.calculateLottoCount(InputView.inputByMoney());
		ResultView.printLottoGameCount(lottoGameCount);

		LottoTicket lottoNumbers = lottoGame.generateLottoNumbers(lottoGameCount, new LottoNumberGenerator());
		ResultView.printLottoNumbers(lottoNumbers);

		LottoGameResultDto lottoGameResultDto = lottoGame.generateLottoGameResult(new Lotto(InputView.inputWinLottoNumbers()), lottoNumbers);
		ResultView.printLottoGameStatistic(lottoGameResultDto);
		ResultView.printProfitRatio(lottoGameResultDto);
	}
}
