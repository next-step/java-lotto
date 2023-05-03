package step2.main;

import step2.domain.vo.LottoPrize;
import step2.domain.vo.Money;
import step2.service.LottoPrizeChecker;
import step2.service.LottoTicketIssuance;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        final var money = InputView.inputMoney();
        final var lottoTickets
                = LottoTicketIssuance.issues(new Money(money));

        OutputView.printTickets(lottoTickets);

        final var lastLottoNumbers = InputView.inputLastLottoNumbers();
        List<LottoPrize> lottoPrizes = LottoPrizeChecker.checker(lottoTickets.getLottoTickets(), lastLottoNumbers);

        OutputView.printWinnerStatistics(lottoTickets, lottoPrizes);
    }
}
