package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.domain.dto.PaymentPriceDTO;
import lotto.step2.domain.dto.ToTalRewardDTO;
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
        resultPrint(paymentPrice, lottoTickets);
    }
    
    private void resultPrint(PaymentPrice paymentPrice, LottoTickets lottoTickets) {
        WinningLottoNumbers winningLottoNumbers = inputWinningLottoNumbers();
        
        winsNumbersPrint(lottoTickets, winningLottoNumbers);
        yieldPrint(getYield(paymentPrice, lottoTickets, winningLottoNumbers));
    }
    
    private void purchasedLottoNumbersPrint(PaymentPrice paymentPrice, LottoTickets lottoTickets) {
        ResultView.purchasedLottoNumbersPrint(lottoTickets, paymentPrice);
    }
    
    private void yieldPrint(double yield) {
        ResultView.yieldPrint(yield);
    }
    
    private double getYield(PaymentPrice paymentPrice, LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        return Referee.yield(getPaymentPriceDTO(paymentPrice), getTotalRewardDTO(getTotalReward(lottoTickets, winningLottoNumbers)));
    }
    
    private ToTalRewardDTO getTotalRewardDTO(ToTalReward totalReward) {
        return totalReward.totalRewardInformation();
    }
    
    private PaymentPriceDTO getPaymentPriceDTO(PaymentPrice paymentPrice) {
        return paymentPrice.paymentPriceInformation();
    }
    
    private ToTalReward getTotalReward(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        return Referee.getTotalReward(getMatchNumbers(lottoTickets, winningLottoNumbers));
    }
    
    private void winsNumbersPrint(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        ResultView.winsNumbersPrint(getWinsNumbers(lottoTickets, winningLottoNumbers));
    }
    
    private WinsNumbers getWinsNumbers(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        return Referee.winsNumbers(getMatchNumbers(lottoTickets, winningLottoNumbers));
    }
    
    private List<MatchNumber> getMatchNumbers(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        return lottoTickets.numberOfMatches(winningLottoNumbers);
    }
    
    private WinningLottoNumbers inputWinningLottoNumbers() {
        return InputView.winningLottoNumbersInput();
    }
}
