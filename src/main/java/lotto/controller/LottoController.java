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

        // 리팩토링 필요 부분
        List<LottoTicket> manualLottoTickets
            = StringSplitter.bulkConvertStrToLottoNumSet(InputView.inputManualNumbers(manualQuantity));
        List<LottoTicket> autoLottoTickets = new AutoLottoGenerator().generate(autoQuantity);

        LottoTickets lottoTickets
            = new LottoTickets(manualLottoTickets).add(new LottoTickets(autoLottoTickets));

        ResultView.showHowManyBuyTicket(manualQuantity, autoQuantity);
        ResultView.showLottoTickets(lottoTickets.getLottoTickets());

        Set<LottoNumber> winningNums = StringSplitter.convertStrToLottoNumSet(InputView.inputWinningNumbers());

        Result result = new Result();
        ResultView.showResultStatics(
            result.aggregateResult(
                lottoTickets.checkTickets(new LottoChecker(winningNums, InputView.inputBonusNumber()))));
        ResultView.showReturnRate(result.calcReturnRate(totalPrice));
    }
}
