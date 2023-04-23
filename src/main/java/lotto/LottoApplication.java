package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount);
        OutputView.printLotteryTickets(lottoGame.getLotteryTickets());
    }
}
