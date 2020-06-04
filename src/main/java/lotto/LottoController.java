package lotto;

import utils.StringAddCalculator;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private int investAmount;
    private int count;
    private static final int LOTTO_PRICE = 1000;
    public static final int[] PRIZE = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private List<LottoTicket> tickets = new ArrayList<>();
    private final InputView inputView = new InputView();
    private final ResultView resultview = new ResultView();
    private final RandomPicker randomPicker = new RandomPicker();
    private List<Integer> winningNumbers = new ArrayList<>();
    private int[] winningmatcher = new int[7];
    private int sumPrize = 0;
    private String numbers;

    public LottoController() {
        investAmount = inputView.inputPurchaseAmount();
        if (investAmount <= 0) {
            throw new IllegalArgumentException("Only positive numbers can be entered.");
        }
        count = investAmount / LOTTO_PRICE;
    }

    public void makeLottoTicket() {
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = new LottoTicket(randomPicker.pickRandomLotto());
            tickets.add(ticket);
        }
    }

    public void printLottoPurchase() {
        resultview.printNumberOfLottoTicek(count);
        resultview.printTickets(tickets);
    }

    public void enterWinningNumbers() {
        numbers = inputView.inputWinningNumber();
    }

    public void calculateWinningStatistics() {
        String[] num = splitWinningNumber(numbers);
        winningNumbers = StringAddCalculator.convertToIntArray(num);
        for (LottoTicket ticket : tickets) {
            int cnt = ticket.matchWinningNumber(winningNumbers);
            winningmatcher[cnt]++;
            sumPrize += PRIZE[cnt];
        }
    }

    public void printWinningStatistics() {
        resultview.printStatistics(winningmatcher, sumPrize / investAmount);
    }

    private String[] splitWinningNumber(String numbers) {
        numbers = removeWhiteSpace(numbers);
        return numbers.split(",");
    }

    private String removeWhiteSpace(String text) {
        return text.replace(" ","");
    }
}
