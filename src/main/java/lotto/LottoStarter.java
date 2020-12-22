package lotto;

import java.util.Map;

import lotto.domain.LottoGame;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.dto.LottoGameResultDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStarter {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();
		int lottoBuyMoney = InputView.inputByMoney();
		int lottoGameCount = lottoGame.calculateLottoCount(lottoBuyMoney);
		ResultView.printLottoGameCount(lottoGameCount);

		LottoTicket lottoNumbers = lottoGame.generateLottoNumbers(lottoGameCount, new LottoNumberGenerator());
		ResultView.printLottoNumbers(lottoNumbers);

		Map<LottoRank, Long> lottoGameResult = lottoGame.generateLottoGameResult(InputView.inputWinLottoNumbers(), lottoNumbers);
		ResultView.printLottoGameStatistic(new LottoGameResultDto(lottoGameResult, lottoBuyMoney));
	}
}
