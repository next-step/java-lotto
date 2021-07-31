package lottos.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    private final int amountPerPiece;

    public Shop(int amountPerPiece) {
        this.amountPerPiece = amountPerPiece;
    }

    public Lottos issue(int purchaseAmount) {
        return new Lottos(this.calculate(purchaseAmount));
    }

    private List<Lotto> calculate(final int purchaseAmount) {
        int count = purchaseAmount / amountPerPiece;
        return IntStream.range(0, count)
                .mapToObj(r -> new Lotto())
                .collect(Collectors.toList());
    }
}
