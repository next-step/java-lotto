package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.domain.issuelottostrategy.AutoLottoIssueStrategy;
import lotto.step2.view.input.InputView;
import lotto.step2.view.output.ResultView;

import java.util.List;

public class Lotto {
    
    public void start() {
        PaymentPrice paymentPrice = inputPaymentPrice();
        LottoTickets lottoTickets = getAutoLottoTickets(paymentPrice);
        print(paymentPrice, lottoTickets);
    }
    
    private PaymentPrice inputPaymentPrice() {
        return InputView.lottoPaymentPriceInput();
    }
    
    private LottoTickets getAutoLottoTickets(PaymentPrice paymentPrice) {
        return LottoMachine.autoIssueLottoTickets(new AutoLottoIssueStrategy(paymentPrice));
    }
    
    private void print(PaymentPrice paymentPrice, LottoTickets lottoTickets) {
        purchasedLottoNumbersPrint(paymentPrice, lottoTickets);
        resultPrint(lottoTickets, paymentPrice);
    }
    
    private List<LottoRank> getLottoRanks(LottoTickets lottoTickets) {
        return lottoTickets.countOfMatchNumbers(inputWinningLottoNumbers());
    }
    
    private List<LottoNumber> inputWinningLottoNumbers() {
        return InputView.winningLottoNumbersInput();
    }
    
    private void purchasedLottoNumbersPrint(PaymentPrice paymentPrice, LottoTickets lottoTickets) {
        ResultView.purchasedLottoNumbersPrint(lottoTickets, paymentPrice);
    }
    
    private void resultPrint(LottoTickets lottoTickets, PaymentPrice paymentPrice) {
        List<LottoRank> lottoRanks = getLottoRanks(lottoTickets);
        
        ResultView.winsNumbersPrint(lottoRanks);
        ResultView.yieldPrint(LottoRank.getYield(lottoRanks, paymentPrice.paymentPriceInformation()));
    }
}
