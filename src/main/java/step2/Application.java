package step2;

import step2.View.InputView;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        int ticketAmount = InputView.buyTickets();
        // 로직처리
        // ResultView.printTickets

        Set<Integer> winningNumber = InputView.getWinningNumbers();
        // 로직처리
        // ResultView.printAnalysis()
    }
}
