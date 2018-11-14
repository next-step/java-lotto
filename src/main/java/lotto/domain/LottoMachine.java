package lotto.domain;

import java.text.MessageFormat;
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
        return LottoResult.create(lottoType, findNumberOfMatchesByLottoType(lottoType));
    }

    private int findNumberOfMatchesByLottoType(LottoType lottoType) {
        return lottoSet.numberOfMatches(target, lottoType.count);
    }

    public enum LottoType {

        THREE(3, 5_000),
        FOUR(4, 50_000),
        FIVE(5, 150_000),
        SIX(6, 2_000_000_000);

        private int count;
        private int price;

        LottoType(int count, int price) {
            this.count = count;
            this.price = price;
        }

        public int computeReward(int numberOfMatches) {
            return this.price * numberOfMatches;
        }

        @Override
        public String toString() {
            return MessageFormat.format("{0}개 일치 ({1}원)", this.count, this.price);
        }
    }
}
