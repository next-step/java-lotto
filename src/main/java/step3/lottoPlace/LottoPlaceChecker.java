package step3.lottoPlace;

import step3.domain.Lotto;
import step3.domain.Lottos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoPlaceChecker {
    private final List<Integer> lastWeekLottoNums;

    private LottoPlaceChecker(List<Integer> lastWeekLottoNums) {
        this.lastWeekLottoNums = lastWeekLottoNums;
    }

    public static LottoPlaceChecker of(List<Integer> lastWeekLottoNums) {
        return new LottoPlaceChecker(lastWeekLottoNums);
    }

    public List<LottoPlace> getLottoPlace(Lottos lottos) {
        List<LottoPlace> results = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            int correctNum = getCorrectNum(lotto);
            results.add(LottoPlace.findPlaceByCorrectNum(correctNum));
        }
        return results;
    }

    private int getCorrectNum(Lotto lotto) {
        return (int) lotto.getLottoNums().stream()
            .filter(lastWeekLottoNums::contains)
            .count();
    }

    public BigDecimal calculateWinnerRate(List<LottoPlace> lottoPlaces, int totalCost) {
        long sum = calculateTotalPrice(lottoPlaces);
        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(totalCost), 6, RoundingMode.HALF_EVEN);
    }

    private static long calculateTotalPrice(List<LottoPlace> lottoPlaces) {
        return lottoPlaces.stream().mapToLong(LottoPlace::getPrice).sum();
    }
}
