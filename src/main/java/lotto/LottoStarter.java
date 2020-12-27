package lotto;

import java.util.Map;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.dto.LottoGameResultDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStarter {
	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();

		int lottoBuyMoney = InputView.inputBuyMoney();
		int lottoTotalCount = lottoGame.calculateLottoCount(lottoBuyMoney);

		int lottoManualCount = InputView.inputManualCount();
		int lottoAutoCount = lottoGame.calculateAutoCount(lottoTotalCount, lottoManualCount);

		LottoTicket lottoTicket = InputView.inputManualLotto(lottoManualCount);

		ResultView.printLottoCount(lottoManualCount, lottoAutoCount);

		lottoTicket.getLottoTicket().addAll(lottoGame.generateLottoNumbers(lottoAutoCount, new LottoNumberGenerator()).getLottoTicket());
		ResultView.printLottoTicket(lottoTicket);

		Map<LottoRank, Long> lottoGameResult = lottoGame.generateLottoGameResult(InputView.inputWinLotto(), lottoTicket);
		ResultView.printLottoGameStatistic(new LottoGameResultDto(lottoGameResult, lottoBuyMoney));
	}
}
