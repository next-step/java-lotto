package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private final LottoSet lottoSet;
    private final List<Integer> target;

    public LottoMachine(LottoSet lottoSet, List<Integer> target) {
        this.lottoSet = lottoSet;
        this.target = target;
    }

    public LottoResultSet createLottoResultSet() {
        List<LottoResult> lottoResults = Arrays.stream(LottoType.values())
                .map(this::createLottoResult)
                .collect(Collectors.toList());
        return LottoResultSet.create(lottoResults);
    }

    private LottoResult createLottoResult(LottoType lottoType) {
        return LottoResult.create(lottoType, findMatchSetByLottoType(lottoType));
    }

    private List<Lotto> findMatchSetByLottoType(LottoType lottoType) {
        return lottoSet.matchSets(target, lottoType.getMatchCount());
    }

    public enum LottoType {

        THREE(3, 5_000),
        FOUR(4, 50_000),
        FIVE(5, 150_000),
        SIX(6, 2_000_000_000);

        private int matchCount;
        private int price;

        LottoType(int matchCount, int price) {
            this.matchCount = matchCount;
            this.price = price;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrice() {
            return price;
        }
    }
}
