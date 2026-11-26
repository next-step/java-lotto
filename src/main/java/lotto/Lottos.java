package lotto;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final LottoNumberGenerator GENERATOR = new LottoNumberGenerator();

    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        this(createLottos(purchaseAmount));
    }

    public Lottos(List<Lotto> lottos) {
        validateNotEmpty(lottos);
        this.lottos = List.copyOf(lottos);
    }

    private static List<Lotto> createLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return Stream.generate(() -> new Lotto(GENERATOR.generate()))
                .limit(purchaseAmount / LOTTO_PRICE)
                .toList();
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_PRICE != 0) {
            throw new RuntimeException("구입 금액 단위 오류");
        }
    }

    private static void validateNotEmpty(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new RuntimeException("로또가 한 장 이상 있어야 합니다.");
        }
    }

    public int count() {
        return lottos.size();
    }

    public int purchaseAmount() {
        return count() * LOTTO_PRICE;
    }

    public List<Prize> calculatePrizes(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> Prize.from(lotto.matchCount(winningLotto)))
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
