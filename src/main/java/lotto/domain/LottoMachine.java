package lotto.domain;

import lotto.utils.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private final LottoSet lottoSet;
    private final List<Integer> target;
    private final int bonusNumber;

    public LottoMachine(LottoSet lottoSet, List<Integer> target, int bonusNumber) {
        this.lottoSet = lottoSet;
        this.target = target;
        this.bonusNumber = bonusNumber;
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
        return lottoType.hasBonus() ?
                lottoSet.numberOfMatches(CollectionUtils.merge(target, bonusNumber), lottoType.count) :
                lottoSet.numberOfMatches(target, lottoType.count);
    }

    public enum LottoType {

        THREE(3, 5_000, "3개 일치 (5000원)"),
        FOUR(4, 50_000, "4개 일치 (50000원)"),
        FIVE(5, 150_000, "5개 일치 (1500000원)"),
        BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
        SIX(6, 2_000_000_000, "6개 일치 (2000000000원)");

        private int count;
        private int price;
        private String description;

        LottoType(int count, int price, String description) {
            this.count = count;
            this.price = price;
            this.description = description;
        }

        public int computeReward(int numberOfMatches) {
            return this.price * numberOfMatches;
        }

        public boolean hasBonus() {
            return this == BONUS;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }
}
