package lotto.controller;

import java.util.stream.Collectors;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Tickets;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningTickets;
import lotto.utils.TextManipulator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

        public static void main(String[] args) {
                long givenAmount = InputView.scanGivenAmount();
                LottoMachine lottoMachine = new LottoMachine();
                Tickets tickets = new Tickets(lottoMachine.buy(givenAmount));
                int purchaseCount = tickets.getCountOfTickets();
                OutputView.printPurchaseCount(purchaseCount);

                OutputView.printGeneratedTickets(tickets.values());

                WinningNumbers winningNumbers = new WinningNumbers(
                    TextManipulator.splitNumberTextByComma(InputView.scanWinningNumberText()).stream()
                        .map(LottoNumber::new).collect(Collectors.toList()),
                    new LottoNumber(InputView.scanBonusNumberText()));
                WinningTickets winningTickets = tickets.analyzeWinningTickets(winningNumbers);

                OutputView.printResultOfWinningTitle();
                OutputView.printResultOfWinning(winningTickets);
                long purchaseAmount = lottoMachine.getPurchaseAmount(tickets);
                OutputView.printRateOfBenefit(winningTickets.calculateRateOfBenefit(purchaseAmount));
        }
}
