package lottos.domain;

import java.util.ArrayList;
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

    public List<Lotto> issue(int purchaseAmount) {
        return new ArrayList<>(this.calculate(purchaseAmount));
    }

    private List<Lotto> calculate(final int purchaseAmount) {
        int count = purchaseAmount / amountPerPiece;
        return IntStream.range(0, count)
                .mapToObj(r -> new Lotto(generator))
                .collect(Collectors.toList());
    }
}
