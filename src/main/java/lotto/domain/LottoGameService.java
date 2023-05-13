package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameService {
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private LottoTickets lottoTickets;
    private WinningNumber winningNumbers;
    private int money;

    public LottoGameService() {
    }

    private LottoGameService(LottoTickets lottoTickets, WinningNumber winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public static LottoGameService of(LottoTickets lottoTickets, WinningNumber winningNumbers) {
        return new LottoGameService(lottoTickets, winningNumbers);
    }

    public static LottoGameService from() {
        return new LottoGameService();
    }

    public int[] countMatchingTickets() {
        return lottoTickets.counterOfMatchingTickets(winningNumbers);
    }

    public double returnRate() {
        Prize prize = Prize.from(countMatchingTickets());
        double result = (double) prize.sumOfPrize() / lottoTickets.totalPrice();
        return Math.floor(result * 100) / 100;
    }

    public void generateTickets(int price) {
        lottoTickets = LottoTickets.from(price);
    }

    public void buyTickets() {
        money = inputView.inputMoney();
        generateTickets(money);
        resultView.printTickets(lottoTickets);
    }

    public void inputWinningNumber() {
        winningNumbers = inputView.inputWinningNumber();
    }

    public void lottoResult() {
        resultView.printResult(countMatchingTickets(), returnRate());
    }
}
