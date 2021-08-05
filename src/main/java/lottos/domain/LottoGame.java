package lottos.domain;


public class LottoGame {

    public LottoGame() {

    }

    public Lottos start(int purchaseAmount, int amountPerPiece) {

        Shop shop = new Shop(new LottoRandomGenerator(), amountPerPiece);
        return shop.issue(purchaseAmount);
    }
}
