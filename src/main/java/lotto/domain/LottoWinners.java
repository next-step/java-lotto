package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoWinners {

    private final Map<LottoPlace, Long> winners;

    private LottoWinners(Map<LottoPlace, Long> winners) {
        this.winners = winners;
    }

    public static LottoWinners of(List<Lotto> lottoList, Lotto weekendLottoNumber, LottoNumber lottoNumber) {
        return new LottoWinners(lottoList
            .stream()
            .map(lotto -> match(lotto, weekendLottoNumber, lottoNumber))
            .filter(lottoPlace -> lottoPlace != LottoPlace.NONE_PLACE)
            .collect(groupingBy(r -> r, counting())));
    }

    public Map<LottoPlace, Long> getWinners() {
        return Collections.unmodifiableMap(winners);
    }

    public Long getWinnerValue(LottoPlace lottoPlace) {
        return winners.get(lottoPlace);
    }

    public long getTotalPrize() {
        return winners.keySet()
            .stream().mapToLong(lottoPlace -> lottoPlace.getPrize() * winners.get(lottoPlace))
            .sum();
    }

    private static LottoPlace match(Lotto item, Lotto weekendLottoNumber, LottoNumber lottoNumber) {
        int matchCount = item.compareLottoNumber(weekendLottoNumber.getItem());
        boolean bonusContain = item.isBonusNumberContains(lottoNumber);

        return LottoPlace.getLottoPlace(matchCount, bonusContain);
    }

}
