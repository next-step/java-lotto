package lotto;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = LottoProcessor.inputAmount();
        Lotto lotto = new Lotto(purchaseAmount);

        LottoProcessor.printLotto(lotto);
        LottoProcessor.getWinningStats(lotto);
    }
}
