package lotto.controller;
import java.util.Set;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.LottoChecker;
import lotto.domain.LottoPurchase;
import lotto.domain.Result;
import lotto.domain.strategy.AutoLottoGenerator;
import lotto.domain.strategy.ManualLottoGenerator;
import lotto.domain.util.StringSplitter;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        LottoPurchase purchase = new LottoPurchase(InputView.inputTotalAmount(), InputView.inputManualQuantity());

        LottoTickets lottoTickets
            = new LottoTickets(
                new ManualLottoGenerator(InputView.inputManualNumbers(purchase.getManualQuantity()))
        	)
            .add(
                new LottoTickets(
                    new AutoLottoGenerator(purchase.calcAutoQuantity())
                )
            );

        ResultView.showHowManyBuyTicket(purchase);
        ResultView.showLottoTickets(lottoTickets.getLottoTickets());

        Set<LottoNumber> winningNums = StringSplitter.convertStrToLottoNumSet(InputView.inputWinningNumbers());

        Result result = new Result();
        ResultView.showResultStatics(
            result.aggregateResult(
                lottoTickets.checkTickets(new LottoChecker(winningNums, InputView.inputBonusNumber()))));
        ResultView.showReturnRate(result.calcReturnRate(purchase.getTotalAmount()));
    }
}
