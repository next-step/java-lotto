package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoWinners {

    private final Map<LottoPlace, Long> winners;

    private LottoWinners(Map<LottoPlace, Long> winners) {
        this.winners = winners;
    }

    public static LottoWinners of(List<Lotto> lottoList, Lotto weekendLottoNumber) {
        return new LottoWinners(lottoList
            .stream()
            .map(lotto -> match(lotto.getItem(), weekendLottoNumber))
            .filter(lottoPlace -> lottoPlace != LottoPlace.NONE_PLACE)
            .collect(groupingBy(r -> r, counting())));
    }

    public Map<LottoPlace, Long> getWinners() {
        return winners;
    }

    public Long getWinnerValue(LottoPlace lottoPlace) {
        return winners.get(lottoPlace);
    }

    public long getTotalPrize() {
        return winners.keySet()
            .stream().mapToLong(lottoPlace -> lottoPlace.getPrize() * winners.get(lottoPlace))
            .sum();
    }

    private static LottoPlace match(Set<LottoNumber> item, Lotto weekendLottoNumber) {
        int matchCount = weekendLottoNumber.compare(item);
        boolean bonus = weekendLottoNumber.bonusCompare(item);

        return LottoPlace.getLottoPlace(matchCount, bonus);
    }

}
