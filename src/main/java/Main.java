public class Main {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        Money money = InputView.askMoney();

        ResultView.prntLottoCount(money);

        Lotto winning = InputView.askWinning();
        GameResult result = game.play(money, winning);

        ResultView.prntCandidates(result.getCandidates());
        ResultView.prntStatistics(game.play(money, winning));
    }
}
