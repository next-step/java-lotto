package step3.io.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import step3.constant.OutputMessage;
import step3.constant.Rank;
import step3.io.ResultView;

public class ConsoleResultView implements ResultView {

    @Override
    public void showInputPrice() {
        System.out.println(OutputMessage.NEED_PRICE.text());
    }

    @Override
    public void showText(String message) {
        System.out.println(message);
    }

    @Override
    public void buyCount(int size) {
        System.out.println(size + OutputMessage.BUY_TEXT.text());
    }

    @Override
    public void showTotalLotto(List<List<Integer>> lotto) {
        for (List<Integer> one : lotto) {
            showOne(one);
        }
    }

    private void showOne(List<Integer> one) {
        List<String> temp = new ArrayList<>();
        for (Integer number : one) {
            temp.add(String.valueOf(number));
        }
        System.out.printf(OutputMessage.ONE_LOTTO.text(),
            String.join(" ", temp));
        System.out.println();
    }

    @Override
    public void showInputVictoryNumber() {
        System.out.println(OutputMessage.NEED_VICTORY_NUMBER.text());
    }

    @Override
    public void showWinning(Map<Rank, Long> winningWithNumbers) {
        System.out.println(OutputMessage.STATISTICS.text());
        System.out.println(OutputMessage.SEPERATOR.text());
        printWinningOne(Rank.FOURTH, winningWithNumbers);
        printWinningOne(Rank.THIRD, winningWithNumbers);
        printWinningOne(Rank.SECOND, winningWithNumbers);
        printWinningOne(Rank.FIRST, winningWithNumbers);

    }

    private void printWinningOne(Rank winnerPrice,
            Map<Rank, Long> winningWithNumbers) {

        System.out.printf(OutputMessage.COUNT.text(),
            winnerPrice.matchedCount(),
            winnerPrice.winnerPrice(),
            winningWithNumbers.getOrDefault(winnerPrice, 0L));
        System.out.println();

    }

    @Override
    public void showEmptyLine() {
        System.out.println();
    }

    @Override
    public void showBenefit(String benefit) {
        System.out.printf(OutputMessage.BENEFIT.text(), benefit);
        System.out.println();
    }

}
