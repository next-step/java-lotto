package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoWinners {

    private static final int MIN_COUNT = 3;
    private final Map<Integer, Long> winners;

    private LottoWinners(Map<Integer, Long> winners) {
        this.winners = winners;
    }

    public static LottoWinners of(List<Lotto> lottoList, Lotto weekendLottoNumber) {
        return new LottoWinners(lottoList
            .stream()
            .map(lotto -> lotto.compare(weekendLottoNumber.getItem()))
            .filter(count -> count >= MIN_COUNT)
            .map(LottoPlace::getLottoPlace)
            .collect(groupingBy(LottoPlace::getCount, counting())));
    }

    public long getLottoPlaceCount(Integer count) {
        return Optional.ofNullable(winners.get(count)).orElse(0L);
    }

    public long getTotalPrize() {
        return winners.keySet()
            .stream().mapToLong(count -> LottoPlace.getLottoPlace(count).getPrize() * winners.get(count))
            .sum();
    }
}
