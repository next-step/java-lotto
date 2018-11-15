package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private final LottoSet lottoSet;
    private final WinningLotto winningLotto;

    public LottoMachine(LottoSet lottoSet, WinningLotto winningLotto) {
        this.lottoSet = lottoSet;
        this.winningLotto = winningLotto;
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
                lottoSet.numberOfMatches(winningLotto.getNumbersWithBonus(), lottoType.count) :
                lottoSet.numberOfMatches(winningLotto.getNumbers(), lottoType.count);
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
