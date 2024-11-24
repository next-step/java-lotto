public class Main {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        Money money = InputView.askMoney();
        ResultView.prntLottoCount(money);

        int manualCount = InputView.askManualLottoCount();
        Candidates manualCandidates = InputView.askManualLottos(manualCount);

        Candidates totalCandidates = game.appendAutoCandidates(money, manualCandidates);
        ResultView.prntTotalCandidates(manualCount, totalCandidates.size() - manualCount, totalCandidates);

        Lotto winning = InputView.askWinning();
        BonusBall bonusBall = InputView.askBonusBall();

        CandidateRanks ranks = game.play(winning, bonusBall, totalCandidates);

        ResultView.prntStatistics(ranks);
    }
}
