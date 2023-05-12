package lotto;

public class LottoGameService {
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private LottoTickets lottoTickets;
    private WinningNumber winningNumbers;
    private int[] matchingResult = new int[7];
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

    public void countMatchingTickets() {
        matchingResult = lottoTickets.counterOfMatchingTickets(winningNumbers);
    }

    public int getCountOfMatchingNumber(int number) {
        return matchingResult[number];
    }

    public double returnRate() {
        double result = (double) sumOfPrize() / lottoTickets.totalPrice();
        return Math.floor(result * 100) / 100;
    }

    public long sumOfPrize() {
        long sumOfFirstPrize = 2000000000 * getCountOfMatchingNumber(6);
        long sumOfSecondPrize = 1500000 * getCountOfMatchingNumber(5);
        long sumOfThirdPrize = 50000 * getCountOfMatchingNumber(4);
        long sumOfFourthPrize = 5000 * getCountOfMatchingNumber(3);
        return sumOfFirstPrize + sumOfSecondPrize + sumOfThirdPrize + sumOfFourthPrize;
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
        countMatchingTickets();
        resultView.printResult(matchingResult, returnRate());
    }
}
