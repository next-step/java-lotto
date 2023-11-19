package lotto.controller;

import java.util.Map;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.Tickets;
import lotto.domain.WinningNumbers;
import lotto.utils.TextManipulator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

        public static void main(String[] args) {
                long purchaseAmount = InputView.scanPurchaseAmount();
                LottoMachine lottoMachine = new LottoMachine();
                Tickets tickets = new Tickets(lottoMachine.buy(purchaseAmount));
                int purchaseCount = tickets.values().size();
                OutputView.printPurchaseCount(purchaseCount);

                OutputView.printGeneratedTickets(tickets.values());

                WinningNumbers winningNumbers = new WinningNumbers(TextManipulator.splitNumberTextByComma(
                    InputView.scanWinningNumberText()));
                winningNumbers.addBonusNumberInToTheWinningNumbers(InputView.scanBonusNumberText());
                Map<Rank, Integer> matchRankCountMap = tickets.countWinningTickets(winningNumbers);

                OutputView.printResultOfWinningTitle();
                OutputView.printResultOfWinning(matchRankCountMap);
                OutputView.printRateOfBenefit(tickets.calculateRateOfBenefit(matchRankCountMap, purchaseAmount));
        }
}
