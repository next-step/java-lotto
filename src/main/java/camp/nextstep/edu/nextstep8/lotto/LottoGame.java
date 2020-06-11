package camp.nextstep.edu.nextstep8.lotto;

public class LottoGame {
    public static void main(String[] args) {
        int purchaseAmount = LottoGameInput.getPurchaseAmount();
        LottoTicket lottoTicket = new LottoTicket(purchaseAmount);

        LottoGameView.showLottoTicket(lottoTicket);

        String winnerNumbers = LottoGameInput.getWinnerNumbersAtLastWeek();
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(winnerNumbers);
        LottoWinningResult result = LottoMatcher.match(lottoTicket, lottoWinnerNumber);

        LottoGameView.showWinningResult(result);
        LottoGameView.showRateOfReturn(purchaseAmount, result.getTotalReward());
    }
}
