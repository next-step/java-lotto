public class Main {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        Money money = InputView.askMoney();
        ResultView.printLottoCount(money);

        int manualCount = InputView.askManualLottoCount();
        Candidates manualCandidates = InputView.askManualLottos(manualCount);

        Candidates totalCandidates = game.appendAutoCandidates(money, manualCandidates);
        ResultView.printTotalCandidates(manualCount, totalCandidates.size() - manualCount, totalCandidates);

        Lotto winning = InputView.askWinning();
        LottoNumber bonusBall = InputView.askBonusBall();

        CandidateRanks ranks = game.play(winning, bonusBall, totalCandidates);

        ResultView.printStatistics(ranks);
    }
}
