package lotto;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lotto = new LottoController();
        lotto.makeLottoTicket();
        lotto.printLottoPurchase();
        lotto.enterWinningNumbers();
        lotto.calculateWinningStatistics();
        lotto.printWinningStatistics();
    }
}
