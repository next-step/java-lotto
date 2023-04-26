package step2;

public class Main {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();

        final Money money = Money.of(inputView.requestMoneyAmount());
        final LottoGame lottoGame = new LottoGame(money);
        resultView.previewLottoGames(lottoGame);

        final YourLottoTicket yourLottoTicket = new YourLottoTicket(inputView.requestYourNumber());
        lottoGame.findWinningResult(yourLottoTicket);

        resultView.printResult(lottoGame);
    }
}
