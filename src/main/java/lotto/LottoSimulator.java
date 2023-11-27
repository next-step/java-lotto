package lotto;

import lotto.domain.Lotto;

import java.util.*;

public class LottoSimulator {
    private static final int EACH_LOTTO_PRICE = 1000;

    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoSimulator() {
    }

    public void buyingLotto(int money) {
        int lottoCount = money / EACH_LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            this.lottoList.add(new Lotto());
        }
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }

    public Map<RewardPrice, Integer> calculateStatistics(Lotto lastWeekWinningLotto) {
        Map<RewardPrice, Integer> statistics = new HashMap<>();
        for (Lotto lotto : lottoList) {
            updateStatistics(lastWeekWinningLotto, lotto, statistics);
        }
        return statistics;
    }

    private static void updateStatistics(Lotto lastWeekWinningLotto, Lotto lotto, Map<RewardPrice, Integer> statistics) {
        int matchCount = lotto.getMatchCount(lastWeekWinningLotto);
        Optional.ofNullable(RewardPrice.fromCount(matchCount))
                        .ifPresent(rewardPrice -> statistics.merge(rewardPrice, 1, Integer::sum));
    }
}
