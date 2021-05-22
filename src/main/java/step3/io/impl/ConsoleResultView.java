package step3.io.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import step3.constant.OutputMessage;
import step3.constant.WinnerPrice;
import step3.io.ResultView;

public class ConsoleResultView implements ResultView {

    private static Pattern pattern;

    public ConsoleResultView() {
        pattern = Pattern.compile("(\\{.\\})");
    }

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
        temp.add(OutputMessage.BRACKETS_START.text());
        for (Integer number : one) {
            temp.add(String.valueOf(number));
        }
        temp.add(OutputMessage.BRACKETS_END.text());
        System.out.println(String.join(" ", temp));
    }

    @Override
    public void showInputVictoryNumber() {
        System.out.println(OutputMessage.NEED_VICTORY_NUMBER.text());
    }

    @Override
    public void showWinning(List<Integer> winningWithNumbers) {
        System.out.println(OutputMessage.STATISTICS.text());
        System.out.println(OutputMessage.SEPERATOR.text());
        showPlace(winningWithNumbers, OutputMessage.THREE_WINNER.text(),
            WinnerPrice.TREE.price(), 3);
        showPlace(winningWithNumbers, OutputMessage.FOUR_WINNER.text(),
            WinnerPrice.FOUR.price(), 4);
        showPlace(winningWithNumbers, OutputMessage.FIVE_WINNER.text(),
            WinnerPrice.FIVE.price(), 5);
        showPlace(winningWithNumbers, OutputMessage.SIX_WINNER.text(),
            WinnerPrice.SIX.price(), 6);
    }

    private void showPlace(List<Integer> winningWithNumbers, String changeText,
            int winningPrice, int winningCount) {

        Matcher matcher = pattern.matcher(changeText);
        changeText = replacePrice(changeText, matcher, winningPrice);
        changeText = replaceCount(changeText, matcher, winningWithNumbers,
            winningCount);

        System.out.println(changeText);
    }

    private String replaceCount(String changeText, Matcher matcher,
            List<Integer> winningWithNumbers, int winningCount) {

        matcher.find();
        return changeText
            .replace(matcher.group(),
                String.valueOf(winningWithNumbers.get(winningCount)));
    }

    private String replacePrice(String changeText, Matcher matcher,
            int winningPrice) {
        matcher.find();
        return changeText
            .replace(matcher.group(), String.valueOf(winningPrice));
    }

    @Override
    public void showEmptyLine() {
        System.out.println();
    }

    @Override
    public void showBenefit(String benefit) {
        String changeText = OutputMessage.BENEFIT.text();
        Matcher matcher = pattern.matcher(changeText);
        System.out.println(replaceBenefit(matcher, changeText, benefit));
    }

    private String replaceBenefit(Matcher matcher, String changeText,
            String benefit) {
        matcher.find();
        return changeText
            .replace(matcher.group(), benefit);
    }

}
