package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.domain.factory.LottoTicketsFactory;
import lotto.step2.domain.issuelottostrategy.AutoLottoIssueStrategy;
import lotto.step2.domain.issuelottostrategy.ManualLottoIssueStrategy;
import lotto.step2.view.input.InputView;
import lotto.step2.view.output.ResultView;

import java.util.List;

public class Lotto {
    
    public void start() {
        PaymentInformation paymentInformation = inputPaymentPrice();
        InputView.inputCountOfManualLotto(paymentInformation);
        
        final LottoTickets lottoTickets = issueManualLottoTickets(paymentInformation);
        lottoTickets.mergeAutoLottos(issueAutoLottoTickets(paymentInformation));
        print(paymentInformation, lottoTickets);
    }
    
    private PaymentInformation inputPaymentPrice() {
        return InputView.inputLottoPaymentPrice();
    }
    
    private static LottoTickets issueManualLottoTickets(final PaymentInformation paymentInformation) {
        return LottoTicketsFactory.of(new ManualLottoIssueStrategy(), paymentInformation);
    }
    
    private LottoTickets issueAutoLottoTickets(PaymentInformation paymentInformation) {
        return LottoTicketsFactory.of(new AutoLottoIssueStrategy(), paymentInformation);
    }
    
    private void print(PaymentInformation paymentInformation, LottoTickets lottoTickets) {
        purchasedLottoNumbersPrint(paymentInformation, lottoTickets);
        resultPrint(lottoTickets, paymentInformation);
    }
    
    private void purchasedLottoNumbersPrint(PaymentInformation paymentInformation, LottoTickets lottoTickets) {
        ResultView.purchasedLottoNumbersPrint(lottoTickets, paymentInformation);
    }
    
    private void resultPrint(LottoTickets lottoTickets, PaymentInformation paymentInformation) {
        List<LottoRank> lottoRanks = getLottoRanks(lottoTickets);
        
        ResultView.winsNumbersPrint(lottoRanks);
        ResultView.yieldPrint(LottoResultCalculator.parseYield(lottoRanks, paymentInformation));
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
