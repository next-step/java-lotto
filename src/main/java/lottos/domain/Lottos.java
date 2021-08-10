package lottos.domain;

import lottos.domain.numbers.Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int AMOUNT_PER_PIECE = 1000;
    private static final int COUNT_OF_LOTTO = 6;

    private final LottoGenerator generator;
    private final List<Lotto> lottos;

    public Lottos(final int purchaseAmount, final LottoGenerator generator) {
        this.generator = generator;
        this.lottos = issue(purchaseAmount);
    }

    public Lottos(final List<Lotto> lottos, final LottoGenerator generator) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("로또가 비어있습니다.");
        }
        this.generator = generator;
        this.lottos = lottos;
    }

    private List<Lotto> issue(int purchaseAmount) {
        final int purchaseCount = calculatePurchaseCount(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Numbers numbers = generator.generate(COUNT_OF_LOTTO);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private static int calculatePurchaseCount(final int purchaseAmount) {
        return purchaseAmount / AMOUNT_PER_PIECE;
    }

    public List<Lotto> elements() {
        return Collections.unmodifiableList(lottos);
    }
}
