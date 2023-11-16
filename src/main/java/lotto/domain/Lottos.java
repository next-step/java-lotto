package lotto.domain;

import java.util.*;

public class Lottos {
    private static final int UNIT = 1000;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos extracted(int amount, NumberGeneration numberGeneration) {
        int count = calculateCount(amount);
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(numberGeneration));
        }

        return new Lottos(lottoList);
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
            LottoRank lottoRank = lotto.findRank(winList, bonus);
            ranks.put(lottoRank, ranks.getOrDefault(lottoRank, 0) + 1);
        }

        return ranks;
    }

    public List<Lotto> find() {
        return Collections.unmodifiableList(lottos);
    }




}
