package lotto;

import lotto.policy.DefaultLottoNumberGeneratePolicy;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoGame lottoGame = new LottoGame(purchaseAmount, new DefaultLottoNumberGeneratePolicy());
        OutputView.printLotteryTickets(lottoGame.getLottoTickets());
    }
}
