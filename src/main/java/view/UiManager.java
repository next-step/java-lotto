package view;

import utils.StringAddCalculator;
import utils.StringUtils;

import java.util.List;

public class UiManager {
    private final InputView inputView = new InputView();
    private int investAmount;
    private static final int LOTTO_PRICE = 1000;


    public int takeCount() {
        investAmount = inputView.inputPurchaseAmount();
        if (investAmount <= 0) {
            throw new IllegalArgumentException("Only positive numbers can be entered.");
        }
        return investAmount / LOTTO_PRICE;
    }

    public List<Integer> takeWinningNumber() {
        String numbers = inputView.inputWinningNumber();
        String[] num = splitWinningNumber(numbers);
        return StringAddCalculator.convertToIntArray(num);
    }

    private String[] splitWinningNumber(String numbers) {
        numbers = StringUtils.removeWhiteSpace(numbers);
        return numbers.split(",");
    }


    public void printWinningStatistics(List<Integer> winningmatcher, int sumPrize) {
        ResultView.printStatistics(winningmatcher, sumPrize / investAmount);
    }

}
