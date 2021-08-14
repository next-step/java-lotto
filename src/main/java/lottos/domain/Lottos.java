package lottos.domain;

import lottos.domain.numbers.Numbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private static final int AMOUNT_PER_PIECE = 1000;
    private static final int COUNT_OF_LOTTO = 6;

    private final LottoGenerator generator;
    private final List<Lotto> lottos;

    public Lottos(final int purchaseAmount, final LottoGenerator generator) {
        this.generator = generator;
        this.lottos = issue(purchaseAmount);
    }

    public Lottos(final int purchaseAmount, final int manualLottoCount, final LottoRandomGenerator lottoRandomGenerator) {
        this(purchaseAmount - (manualLottoCount * AMOUNT_PER_PIECE), lottoRandomGenerator);
    }

    public Lottos(final List<Lotto> lottos, final LottoGenerator generator) {
        this.generator = generator;
        this.lottos = lottos;
    }

    private List<Lotto> issue(final int purchaseAmount) {
        final int purchaseCount = calculatePurchaseCount(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Numbers numbers = generator.generate(COUNT_OF_LOTTO);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public Lottos merge(final Lottos lottos) {
        List<Lotto> mergeLottos = Stream.of(this.lottos, lottos.lottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new Lottos(mergeLottos, this.generator);
    }

    private static int calculatePurchaseCount(final int purchaseAmount) {
        return purchaseAmount / AMOUNT_PER_PIECE;
    }

    public List<Lotto> elements() {
        return Collections.unmodifiableList(lottos);
    }

    public int count() {
        return this.elements().size();
    }
}
