package lotto.step2.controller;

import lotto.step2.domain.LottoMachine;
import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.PaymentPrice;
import lotto.step2.domain.issuelottostrategy.AutoLottoIssueStrategy;
import lotto.step2.view.input.InputView;
import lotto.step2.view.output.ResultView;

public class Lotto {
    
    public void start() {
        PaymentPrice paymentPrice = InputView.lottoPaymentPriceInput();
        LottoTickets lottoTickets = LottoMachine.autoIssueLottoTickets(new AutoLottoIssueStrategy(paymentPrice));
        ResultView.purchasedLottoNumbersPrint(lottoTickets, paymentPrice);
    }
}
