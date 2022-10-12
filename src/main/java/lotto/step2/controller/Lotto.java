package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.domain.factory.LottoTicketsFactory;
import lotto.step2.domain.issuelottostrategy.AutoLottoIssueStrategy;
import lotto.step2.view.input.InputView;
import lotto.step2.view.output.ResultView;

import java.util.List;

public class Lotto {
    
    public void start() {
        PaymentPrice paymentPrice = inputPaymentPrice();
        
        LottoTickets lottoTickets = issueAutoLottoTickets(paymentPrice);
        print(paymentPrice, lottoTickets);
    }
    
    private PaymentPrice inputPaymentPrice() {
        return InputView.inputLottoPaymentPrice();
    }
    
    private LottoTickets issueAutoLottoTickets(PaymentPrice paymentPrice) {
        return LottoTicketsFactory.from(new AutoLottoIssueStrategy(), paymentPrice);
    }
    
    private void print(PaymentPrice paymentPrice, LottoTickets lottoTickets) {
        purchasedLottoNumbersPrint(paymentPrice, lottoTickets);
        resultPrint(lottoTickets, paymentPrice);
    }
    
    private void purchasedLottoNumbersPrint(PaymentPrice paymentPrice, LottoTickets lottoTickets) {
        ResultView.purchasedLottoNumbersPrint(lottoTickets, paymentPrice);
    }
    
    private void resultPrint(LottoTickets lottoTickets, PaymentPrice paymentPrice) {
        List<LottoRank> lottoRanks = getLottoRanks(lottoTickets);
    
        ResultView.winsNumbersPrint(lottoRanks);
        ResultView.yieldPrint(LottoResultCalculator.parseYield(lottoRanks, paymentPrice));
    }
    
    private List<LottoRank> getLottoRanks(final LottoTickets lottoTickets) {
        return lottoTickets.parseLottoRanks(inputWinningLottoNumbers());
    }
    
    private WinningLottoNumbers inputWinningLottoNumbers() {
        final WinningLottoNumbers winningLottoNumbers = InputView.inputWinningLottoNumber();
        InputView.inputWinningBonusLottoNumber(winningLottoNumbers);
        return winningLottoNumbers;
    }
}
