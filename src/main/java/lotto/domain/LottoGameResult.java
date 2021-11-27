package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoGameResult {
    private final Lotties lotties;
    private final Lotto winLotto;
    private final Map<Rank, Long> result;

    public LottoGameResult(Lotties lotties, Lotto winLotto) {
        this.lotties = lotties;
        this.winLotto = winLotto;
        this.result = getLottiesRank();
    }

    public double getRate() {
        int purchaseLottoMoney = Store.LOTTO_ONE_GAME_PRICE * lotties.purchaseLottiesCount();
        long prizeMoney = result.keySet().stream()
                                        .map(Rank::getPrizeMoney)
                                        .reduce(0, Integer::sum);
        return prizeMoney / purchaseLottoMoney;
    }

    public long getRankCount(Rank rank) {
        return this.result.getOrDefault(rank, 0L);
    }

    public Map<Rank, Long> getLottiesRank() {
        return lotties.getLotties().stream()
                            .map(winLotto::getRank)
                            .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }
}
