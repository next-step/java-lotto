package view;

import lotto.LottoTicket;
import utils.StringAddCalculator;
import utils.StringUtils;

import java.util.List;
import java.util.Set;

public class UiManager {
    private final InputView inputView = new InputView();
    private int investAmount;
    private static final int LOTTO_PRICE = 1000;


    public int takeCount() {
        investAmount = inputView.inputPurchaseAmount();
        if (investAmount <= 0) {
            throw new IllegalArgumentException("Only positive numbers can be entered.");
        }
        return takeCount(investAmount);
    }

    public Set<Integer> takeWinningNumber() {
        String numbers = inputView.inputWinningNumber();
        String[] num = splitWinningNumber(numbers);
        return StringAddCalculator.convertToIntSet(num);
    }

    private String[] splitWinningNumber(String numbers) {
        numbers = StringUtils.removeWhiteSpace(numbers);
        return numbers.split(",");
    }

    public void printLottoPurchase(int count, List<LottoTicket> tickets) {
        ResultView.printNumberOfLottoTicek(count);
        ResultView.printTickets(tickets);
    }

    public void printWinningStatistics(List<Integer> winningmatcher, int sumPrize) {
        ResultView.printStatistics(winningmatcher, sumPrize / (double)investAmount);
    }

    private int takeCount(int investAmount) {
        int count = investAmount / LOTTO_PRICE;
        if (count <= 0) {
            throw new IllegalArgumentException("Please enter more than the ticket price.");
        }
        return investAmount / LOTTO_PRICE;
    }

}
