package step2.lottoPlace;

import step2.domain.Lotto;
import step2.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoPlaceChecker {
    private List<Integer> lastWeekLottoNums;

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
}
