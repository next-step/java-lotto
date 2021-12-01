package lotto.domain;

public class LottoGame {
    private final int purchaseAmount;
    private final int buyRound;

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.buyRound = purchaseAmount / 1000;
    }

    public int getBuyRound() {
        return buyRound;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

//    public Lottos start(){
//        return
//    }
}
