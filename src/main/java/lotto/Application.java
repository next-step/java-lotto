package lotto;

import lotto.domain.*;
import lotto.matcher.LottoMatcher;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int buyLottoAmount = InputView.inputLottoBuyAmount();
        int manualCount = InputView.inputManualCount();
        // 수동 로또 구매 번호가 필요
        LottoTickets lottoTickets = InputView.inputManualNumbers(manualCount);

        LottoBuyer lottoBuyer = new LottoBuyer(buyLottoAmount, new LottoShop(), lottoTickets);
        LottoTickets buyLottoTickets = lottoBuyer.buyLotto();

        // 개수 출력 및 번호 출력
        OutputView.outputBuyCount(buyLottoTickets.getPurchaseTicketCount());
        OutputView.outputLottoNumbers(buyLottoTickets);

        // 지난주 당첨 번호 입력
        List<Lotto> winnerNumbers = InputView.inputWinningNumbers();
        Lotto bonusBall = new Lotto(InputView.inputBonusNumber());

        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(winnerNumbers, bonusBall);
        List<LottoMatcher> lottoMatchers = buyLottoTickets.findLottoMatchResults(lottoWinnerNumber);

        BigDecimal earningRate = lottoBuyer.calculateEarningsRate(lottoMatchers);

        OutputView.output();
        OutputView.outputRankingStatistics(lottoMatchers);
        OutputView.outputEarningRate(earningRate);
    }
}
