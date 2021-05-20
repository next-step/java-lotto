package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.winning.WinningNumbers;
import lotto.winning.WinningStatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int DEFAULT_PRICE = 1000;
    private static final String MATCH_PRICE = "^[0-9]+$";
    private static final String EXCEPTION_MESSAGE = "정수만 입력해주세요.";

    private LottoCount lottoCount;
    private List<Integer> defaultLottoNumbers;
    private WinningNumbers winningNumbers;

    public Lotto() {
        defaultLottoNumbers = new ArrayList<>();
        createLottoDefaultNumberRange();
    }

    public void purchaseLotto() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        inputView.printInputPurchasePrice();
        String purchasePrice = inputView.inputPurchasePrice();
        this.lottoCount = new LottoCount(calculatePrice(validateInputPrice(purchasePrice)));
        inputView.printPurchasePrice(lottoCount);
        List<LottoTicket> tickets = createLottoTickets(inputView, resultView);
        showLottoWinningStatistics(tickets, purchasePrice);
    }

    public List<LottoTicket> createLottoTickets(InputView inputView, ResultView resultView) {
        List<LottoTicket> tickets = createLottoRandomNumbers(this.lottoCount.getLottoCount());
        resultView.printLottoNumbers(tickets);
        inputView.printLastWeeksWinningNumber();
        winningNumbers = new WinningNumbers(inputView.inputLastWeeksWinningNumber());
        return tickets;
    }

    public void showLottoWinningStatistics(List<LottoTicket> tickets, String purchasePrice) {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.calculateTotalWinningPoint(tickets,winningNumbers.getWinningNumbers());
        winningStatistics.showWinningStatistics(Integer.parseInt(purchasePrice));

    }

    protected int validateInputPrice(String price) {
        if (!price.matches(MATCH_PRICE)) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        return Integer.parseInt(price);
    }

    public int calculatePrice(int price) {
        return price / DEFAULT_PRICE;
    }

    private void createLottoDefaultNumberRange() {
        for (int i = 1; i <= 45; i++) {
            this.defaultLottoNumbers.add(i);
        }
    }

    public List<LottoTicket> createLottoRandomNumbers(int lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(this.defaultLottoNumbers);
            LottoTicket lottoTicket = new LottoTicket(createSixNumbers(this.defaultLottoNumbers));
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public List<Integer> createSixNumbers(List<Integer> defaultLottoNumbers) {
        List<Integer> sixNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            sixNumbers.add(defaultLottoNumbers.get(i));

        }
        return sixNumbers;
    }
}
