package lotto;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputAmount();
        Lotto lotto = new Lotto(purchaseAmount);
        LottoProcessor lottoProcessor = new LottoProcessor(lotto);
        lottoProcessor.printLotto();

        String winningNumbers = InputView.inputLastWinningNumbers();
        lottoProcessor.getWinningStats(winningNumbers);
    }
}
