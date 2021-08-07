package lottos.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;
    private static final int amountPerPiece = 1000;
    private static final LottoGenerator generator = new LottoRandomGenerator();

    public Lottos(final int purchaseAmount) {
        this(issue(purchaseAmount));
    }

    public Lottos(final List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("로또가 비어있습니다.");
        }
        this.lottos = lottos;
    }

    private static List<Lotto> issue(final int purchaseAmount) {
        final int purchaseCount = calculatePurchaseCount(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = generator.generate();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static int calculatePurchaseCount(final int purchaseAmount) {
        return purchaseAmount / amountPerPiece;
    }

    public List<LottoResult> match(final Lotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }

    public List<Lotto> elements() {
        return Collections.unmodifiableList(lottos);
    }
}
