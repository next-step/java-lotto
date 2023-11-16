package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    private static final int EACH_LOTTO_PRICE = 1000;

    private static int lottoCount;
    private final List<Lotto> lottos = new ArrayList<>();

    private LottoSimulator() {
    }

    public static LottoSimulator initLottoSimulator(int money) {
        LottoSimulator lottoSimulator = new LottoSimulator();
        lottoSimulator.lottoCount = money / EACH_LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottoSimulator.lottos.add(Lotto.of(NumberShuffler.getShuffledNumbers()));
        }

        return lottoSimulator;
    }

    public int[] getStatistics(List<Integer> lastWeekLottoNumbers) {
        // TODO 각 매치 갯수에 해당하는 인덱스에 넣어버리기
        int[] statistics = new int[7]; // TODO 매직넘버 리펙토링
        for (Lotto lotto : lottos) { // 각 로또별로 순회하면서
            statistics[lotto.getMatchCount(lastWeekLottoNumbers)]++;
        }
        return statistics;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List getLottos() {
        return lottos;
    }
}
