package Lotto.domain;

import Lotto.constants.LottoPrize;

import java.util.*;

import static Lotto.constants.LottoConstants.*;

public class LottoList {
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

    public static List<LottoNumber> generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        Collections.shuffle(lottoNumbers);

        List<LottoNumber> result = new ArrayList<>();
        for (int i = 0; i < LOTTO_PICK_COUNT; i++) {
            result.add(lottoNumbers.get(i));
        }

        result.sort((n1, n2) -> Integer.compare(n1.getNumber(), n2.getNumber()));

        return result;
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
