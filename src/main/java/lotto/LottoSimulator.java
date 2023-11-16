package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    private static final int EACH_LOTTO_PRICE = 1000;
    private static final int LOTTO_STATISTICS_SIZE = 7;

    private final List<Lotto> lottoList = new ArrayList<>();

    private LottoSimulator() {
    }

    public static LottoSimulator initLottoSimulator(int money) {
        LottoSimulator lottoSimulator = new LottoSimulator();
        int lottoCount = money / EACH_LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottoSimulator.lottoList.add(Lotto.of(NumberShuffler.getShuffledNumbers()));
        }
        return lottoSimulator;
    }

    public int[] getStatistics(List<Integer> lastWeekLottoNumbers) {
        int[] statistics = new int[LOTTO_STATISTICS_SIZE];
        for (Lotto lotto : lottoList) {
            statistics[lotto.getMatchCount(lastWeekLottoNumbers)]++;
        }
        return statistics;
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
