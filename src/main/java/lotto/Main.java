package lotto;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        Lotto lotto = new Lotto(purchaseAmount);

        LottoProcessor lottoProcessor = new LottoProcessor(lotto);
        lottoProcessor.publish();

        String winningNumbers = InputView.inputLastWinningNumbers();
        lottoProcessor.calculateWinningStats(winningNumbers);
        lottoProcessor.printWinningStats();
    }
}
