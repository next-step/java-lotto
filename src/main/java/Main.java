public class Main {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        Money money = InputView.askMoney();

        ResultView.prntLottoCount(money);

        Lotto winning = InputView.askWinning();

        Candidates candidates = game.setup(money);
        CandidateRanks ranks = game.play(winning, candidates);

        ResultView.prntCandidates(candidates);
        ResultView.prntStatistics(ranks);
    }
}
