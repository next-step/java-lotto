package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    private static final int EACH_LOTTO_PRICE = 1000;
    private static final int LOTTO_STATISTICS_SIZE = 7;

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

    public int[] calculateStatistics(List<Integer> lastWeekLottoNumbers) {
        int[] statistics = new int[LOTTO_STATISTICS_SIZE];
        for (Lotto lotto : lottoList) {
            statistics[lotto.getMatchCount(lastWeekLottoNumbers)]++;
        }
        return statistics;
    }
}
