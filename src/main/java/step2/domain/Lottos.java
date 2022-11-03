package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final String LOTTO_PRICE_EXCEPTION = "로또 금액에 맞춰 구입해주세요.";

    private final List<Lotto> lottos;

    public Lottos(PurchasePrice purchasePrice) {
        this.lottos = validationPrice(purchasePrice);
    }

    private static List<Lotto> validationPrice(PurchasePrice purchasePrice) {
        if (purchasePrice.getPurchasePrice() % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_EXCEPTION);
        }
        return createLottos(getLottoCount(purchasePrice.getPurchasePrice()));
    }

    private static List<Lotto> createLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

    public List<LottoRank> lottoRanks(WinningNumbers winningLottoNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.countMatchNumber(winningLottoNumbers))
                .map(LottoRank::countOfMatchNumber)
                .collect(Collectors.toList());
    }

    public static int getLottoCount(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(getLottos(), lottos1.getLottos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottos());
    }
}
