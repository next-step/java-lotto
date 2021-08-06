package lottos.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    private final LottoGenerator generator;
    private final int amountPerPiece;

    public Shop(LottoGenerator generator, int amountPerPiece) {
        this.generator = generator;
        this.amountPerPiece = amountPerPiece;
    }

    public Lottos issue(final int purchaseAmount) {
        int purchaseCount = calculatePurchaseCount(purchaseAmount);

        List<Lotto> lottos = IntStream.range(0, purchaseCount)
                .mapToObj(r -> new Lotto(generator))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    private int calculatePurchaseCount(int purchaseAmount) {
        return purchaseAmount / amountPerPiece;
    }
}
