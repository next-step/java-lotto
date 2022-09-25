package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.domain.issuelottostrategy.AutoLottoIssueStrategy;
import lotto.step2.view.input.InputView;
import lotto.step2.view.output.ResultView;

import java.util.List;

public class Lotto {
    
    public void start() {
        PaymentPrice paymentPrice = InputView.lottoPaymentPriceInput();
        LottoTickets lottoTickets = LottoMachine.autoIssueLottoTickets(new AutoLottoIssueStrategy(paymentPrice));
        ResultView.purchasedLottoNumbersPrint(lottoTickets, paymentPrice);
    
        WinningLottoNumbers winningLottoNumbers = InputView.winningLottoNumbersInput();
    
        List<MatchNumber> matchNumbers = lottoTickets.numberOfMatches(winningLottoNumbers);
        WinsNumbers winsNumbers = Referee.winsNumbers(matchNumbers);
        ResultView.winsNumbersPrint(winsNumbers);
    }
}
