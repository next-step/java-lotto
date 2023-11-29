package lotto.controller;
import java.util.List;
import java.util.Set;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoChecker;
import lotto.domain.LottoShop;
import lotto.domain.Result;
import lotto.domain.strategy.AutoLottoGenerator;
import lotto.domain.util.StringSplitter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        int totalPrice = InputView.inputTotalAmount();
        int ticketQuantity = new LottoShop().sellTicket(totalPrice);
        int manualQuantity = InputView.inputManualQuantity();
        int autoQuantity = ticketQuantity - manualQuantity;

        List<LottoTicket> manualLottoTickets
            = StringSplitter.bulkConvertStrToLottoNumSet(InputView.inputManualNumbers(manualQuantity));

        ResultView.showHowManyBuyTicket(ticketQuantity);

        LottoTickets lottoTickets = new LottoTickets(ticketQuantity, new AutoLottoGenerator());
        ResultView.showLottoTickets(lottoTickets.getLottoTickets());

        Set<LottoNumber> winningNums = StringSplitter.convertStrToLottoNumSet(InputView.inputWinningNumbers());

        Result result = new Result();
        ResultView.showResultStatics(
            result.aggregateResult(
                lottoTickets.checkTickets(new LottoChecker(winningNums, InputView.inputBonusNumber()))));
        ResultView.showReturnRate(result.calcReturnRate(totalPrice));
    }
}
