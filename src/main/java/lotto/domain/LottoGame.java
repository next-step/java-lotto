package lotto.domain;

public class LottoGame {
    private final int buyRound;

    public LottoGame(int purchaseAmount) {
        this.buyRound = purchaseAmount / 1000;
    }

    public int getBuyRound() {
        return buyRound;
    }

//    public Lottos start(){
//        return
//    }
}
