package Lotto.domain;

import Lotto.constants.LottoPrize;

import java.util.*;

import static Lotto.domain.Lotto.generateLottoNumbers;

public class LottoList {
    public static final int LOTTO_PICK_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final List<Lotto> lottos;

    public LottoList() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> generateLottos(int purchasedQty) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchasedQty; i++) {
            List<LottoNumber> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
            this.lottos.add(lotto);
        }
        return lottos;
    }

    public Map<LottoPrize, Integer> calculateStats(Set<LottoNumber> winningNumbers) {
        Map<LottoPrize, Integer> stats = new HashMap<>();

        for (LottoPrize prize : LottoPrize.values()) {
            stats.put(prize, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            LottoPrize prize = LottoPrize.fromMatchCount(matchCount);
            if (prize != null) {
                stats.put(prize, stats.get(prize) + 1);
            }
        }

        return stats;
    }
}
