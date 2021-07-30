package step2.lottoPlace;

import step2.domain.Lotto;
import step2.domain.Lottos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
            int distinctNum = getDistinctNum(lotto);
            results.add(LottoPlace.findPlaceByDistinctNum(distinctNum));
        }
        return results;
    }

    private int getDistinctNum(Lotto lotto) {
        return (int) Stream.concat(lastWeekLottoNums.stream(), lotto.getLottoNums().stream())
            .distinct()
            .count();
    }

    public BigDecimal calculateWinnerRate(List<LottoPlace> lottoPlaces, int totalCost) {
        long sum = calculateTotalPrice(lottoPlaces);
        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(totalCost));
    }

    private static long calculateTotalPrice(List<LottoPlace> lottoPlaces) {
        return lottoPlaces.stream().mapToLong(LottoPlace::getPrice).sum();
    }
}
