package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buyLotto(int lottoPrice) {
        int lottoCount = getLottoCount(lottoPrice);
        List<Lotto> lottos = createLottos(lottoCount);
        return new Lottos(lottos);
    }

    private static int getLottoCount(int lottoPrice) {
        if (lottoPrice < Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 " + Lotto.LOTTO_PRICE + "원 이상이어야 합니다.");
        }
        if (lottoPrice % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 " + Lotto.LOTTO_PRICE + "원 단위로만 가능합니다.");
        }
        return lottoPrice / Lotto.LOTTO_PRICE;
    }

    private static List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createRandomly());
        }
        return lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Lottos merge(Lottos otherLottos) {
        List<Lotto> mergedLottos = new ArrayList<>(this.lottos);
        mergedLottos.addAll(otherLottos.lottos);
        return new Lottos(mergedLottos);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public EnumMap<LottoResult, Integer> getResultMap(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::getResult)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        () -> new EnumMap<>(LottoResult.class),
                        Collectors.summingInt(result -> 1)
                ));
    }
}
