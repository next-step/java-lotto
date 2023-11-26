package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBundle {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottoList;

    public LottoBundle(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoBundle(LottoGenerator lottoGenerator, int lottoPurchasedPrice) {
        this(IntStream.range(0, lottoPurchasedPrice / LOTTO_PRICE)
                .mapToObj(i -> new Lotto(lottoGenerator))
                .collect(Collectors.toList()));
    }

    public Map<LottoResult, Integer> checkWinningResult(Lotto winningLotto) {
        Map<LottoResult, Integer> lottoResults = Arrays.stream(LottoResult.values())
                .collect(Collectors.toMap(key -> key, value -> 0, (x, y) -> y, () -> new EnumMap<>(LottoResult.class)));

        for (Lotto lotto : lottoList) {
            LottoResult lottoResult = lotto.match(winningLotto);
            lottoResults.put(lottoResult, lottoResults.get(lottoResult) + 1);
        }

        return lottoResults;
    }

    public int lottoCount() {
        return lottoList.size();
    }

    public List<Lotto> lottoList() {
        return lottoList;
    }

    public int purchasedPrice() {
        return lottoCount() * LOTTO_PRICE;
    }
}
