package step4.lottoPlace;

import step4.domain.Lotto;
import step4.domain.Lottos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoPlaceChecker {
    private final LastWeekLotto lastWeekLotto;

    private LottoPlaceChecker(LastWeekLotto lastWeekLotto) {
        this.lastWeekLotto = lastWeekLotto;
    }

    public static LottoPlaceChecker of(LastWeekLotto lastWeekLotto) {
        return new LottoPlaceChecker(lastWeekLotto);
    }

    private static long calculateTotalPrice(List<LottoPlace> lottoPlaces) {
        return lottoPlaces.stream()
            .mapToLong(LottoPlace::getPrice)
            .sum();
    }

    public List<LottoPlace> getLottoPlace(Lottos lottos) {
        List<LottoPlace> results = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            int correctNum = countCorrectNum(lotto);
            boolean isBonusNumCorrect = isBonusNumCorrect(lotto);
            results.add(LottoPlace.findPlaceByCorrectNum(correctNum, isBonusNumCorrect));
        }
        return results;
    }

    private int countCorrectNum(Lotto lotto) {
        return lotto.countCorrectNums(lastWeekLotto);
    }

    private boolean isBonusNumCorrect(Lotto lotto) {
        return lotto.isLottoNumContainsBonusNum(lastWeekLotto);
    }

    public BigDecimal calculateWinnerRate(List<LottoPlace> lottoPlaces, int totalCost) {
        long sum = calculateTotalPrice(lottoPlaces);
        return BigDecimal.valueOf(sum)
            .divide(BigDecimal.valueOf(totalCost), 6, RoundingMode.HALF_EVEN);
    }
}
