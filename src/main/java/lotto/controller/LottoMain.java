package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchaseAmount;
import lotto.domain.Tickets;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningTickets;
import lotto.utils.TextManipulator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

        public static void main(String[] args) {
                PurchaseAmount inputAmount = PurchaseAmount.createPurchaseAmount(InputView.inputAmount());
                int countOfManualTicket = InputView.inputCountOfManualNumberTicket();

                LottoMachine lottoMachine = new LottoMachine();
                Tickets tickets = new Tickets(null);
                if (!hasManualTicket(countOfManualTicket)) {
                        tickets = lottoMachine.buyOnlyAutoTickets((inputAmount));
                }
                if (hasManualTicket(countOfManualTicket)) {
                        List<LottoNumbers> manualLottoNumbers = markManualLottoNumbers(countOfManualTicket);
                        tickets = lottoMachine.buyAutoAndManualTickets(inputAmount, manualLottoNumbers);
                }

                int purchaseCount = tickets.getCountOfTickets();
                OutputView.printPurchaseCount(purchaseCount);

                OutputView.printGeneratedTickets(tickets.values());

                WinningNumbers winningNumbers = new WinningNumbers(
                    TextManipulator.splitNumberTextByComma(InputView.inputWinningNumberText()).stream()
                        .map(LottoNumber::new).collect(Collectors.toList()),
                    new LottoNumber(InputView.inputBonusNumberText()));
                WinningTickets winningTickets = tickets.analyzeWinningTickets(winningNumbers);

                OutputView.printResultOfWinningTitle();
                OutputView.printResultOfWinning(winningTickets);
                long netPurchaseAmount = inputAmount.calculateNetPurchaseAmount(tickets);
                OutputView.printRateOfBenefit(winningTickets.calculateRateOfBenefit(netPurchaseAmount));
        }

        private static boolean hasManualTicket(int countOfManualTicket) {
                return countOfManualTicket > 0;
        }

        private static List<LottoNumbers> markManualLottoNumbers(int countOfManualTicket) {
                return InputView.inputManualNumbers(countOfManualTicket)
                    .stream().map(LottoMain::convertLottoNumbersTextToLottoNumbers).collect(Collectors.toList());
        }

        private static LottoNumbers convertLottoNumbersTextToLottoNumbers(String lottoNumbersText) {
                return new LottoNumbers(
                    TextManipulator.splitNumberTextByComma(lottoNumbersText).stream().map(LottoNumber::new)
                        .collect(Collectors.toUnmodifiableSet()));
        }
}
