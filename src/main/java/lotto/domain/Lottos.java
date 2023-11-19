package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public static Lottos generate(List<List<Integer>> manualNumbers, NumberGeneration numberGeneration, int count) {
        List<Lotto> list = new ArrayList<>();
        int randomCount = count - manualNumbers.size();

        manualGenerate(manualNumbers, list);
        autoGenerate(numberGeneration, randomCount, list);

       return new Lottos(list);
    }

    private static void autoGenerate(NumberGeneration numberGeneration, int randomCount, List<Lotto> list) {
        for (int i = 0; i < randomCount; i++) {
            list.add(new Lotto(numberGeneration.generate()));
        }
    }

    private static void manualGenerate(List<List<Integer>> manualNumbers, List<Lotto> list) {
        for (List<Integer> manualNumber : manualNumbers) {
            list.add(new Lotto(manualNumber));
        }
    }

    public Map<LottoRank, Integer> findRanks(Lotto winLotto, LottoNumber bonus) {
        Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.findRank(winLotto, bonus);
            ranks.put(lottoRank, ranks.getOrDefault(lottoRank, 0) + 1);
        }

        return ranks;
    }

    public List<Lotto> find() {
        return Collections.unmodifiableList(lottos);
    }


}
