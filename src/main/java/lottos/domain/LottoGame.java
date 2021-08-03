package lottos.domain;

import java.util.List;

public class LottoGame {

    private LottoGenerator generator;

    public LottoGame(LottoGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> start(int purchaseAmount, int pricePerPiece) {
        Shop shop = new Shop(generator, pricePerPiece);
        return shop.issue(purchaseAmount);
    }
}
