package lotto.controller;
import java.util.Set;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.LottoChecker;
import lotto.domain.LottoShop;
import lotto.domain.Result;
import lotto.domain.strategy.AutoGenerateStrategy;
import lotto.domain.util.StringSplitter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        int totalPrice = InputView.inputTotalAmount();
        int ticketQuantity = new LottoShop().sellTicket(totalPrice);
        ResultView.showHowManyBuyTicket(ticketQuantity);

        LottoTickets lottoTickets = new LottoTickets(ticketQuantity, new AutoGenerateStrategy());
        ResultView.showLottoTickets(lottoTickets.getLottoTickets());

        Set<Integer> winningNums = StringSplitter.convertToIntegerSet(InputView.inputWinningNumbers());

        Result result = new Result();
        ResultView.showResultStatics(
            result.aggregateResult(
                lottoTickets.checkTickets(new LottoChecker(winningNums, InputView.inputBonusNumber()))));
        ResultView.showReturnRate(result.calcReturnRate(totalPrice));
    }
}
