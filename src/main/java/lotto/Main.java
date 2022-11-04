package lotto;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        LottoProcessor lottoProcessor = new LottoProcessor(purchaseAmount);
        lottoProcessor.publish(purchaseAmount);

        String winningNumbers = InputView.inputLastWinningNumbers();
        lottoProcessor.calculateWinningStats(winningNumbers);
        lottoProcessor.printWinningStats(purchaseAmount);
    }
}
