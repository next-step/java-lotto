package lotto.domain;

import calculator.domain.NumberGeneration;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int UNIT = 1000;
    private final List<Lotto> lottos;

    public Lottos(int amount, NumberGeneration numberGeneration) {
        int count = calculateCount(amount);
        this.lottos = extracted(count, numberGeneration);
    }

    private List<Lotto> extracted(int count, NumberGeneration numberGeneration) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(numberGeneration));
        }

        return lottoList;
    }

    private static int calculateCount(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("금액은 " + UNIT + "단위 입니다");
        }

        return amount / UNIT;
    }

    public int count() {
        return lottos.size();
    }

    public Map<LottoRank, Integer> findRanks(List<Integer> winList, int bonus) {
        Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottos) {
            addRanks(winList, bonus, lotto, ranks);

        }

        return ranks;
    }

    private static void addRanks(List<Integer> winList, int bonus, Lotto lotto, Map<LottoRank, Integer> ranks) {
        if(lotto.isRank(winList)){
            LottoRank lottoRank = LottoRank.findMatchCount(lotto.countMath(winList), lotto.isHaveBonus(bonus));
            ranks.put(lottoRank, ranks.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public List<String> find() {
        List<String> lottoList = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoList.add(lotto.find().toString());
        }

        return lottoList;
    }
}
