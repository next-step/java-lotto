package lotto.domain;

import lotto.domain.strategy.NumberGeneration;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public static Lottos generate(List<NumberGeneration> manualNumbers, NumberGeneration numberGeneration, PurchaseQuantity randomQuantity) {
        List<Lotto> list = new ArrayList<>();

        manualGenerate(manualNumbers, list);
        autoGenerate(numberGeneration, randomQuantity, list);

        return new Lottos(list);
    }

    private static void autoGenerate(NumberGeneration numberGeneration, PurchaseQuantity randomQuantity, List<Lotto> list) {
        for (int i = 0; i < randomQuantity.find(); i++) {
            list.add(new Lotto(numberGeneration));
        }
    }

    private static void manualGenerate(List<NumberGeneration> manualNumbers, List<Lotto> list) {
        for (NumberGeneration manualNumber : manualNumbers) {
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
