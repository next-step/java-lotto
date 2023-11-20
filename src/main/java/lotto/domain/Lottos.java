package lotto.domain;

import lotto.domain.strategy.LottoGeneration;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(PurchaseQuantity autoQuantity, List<LottoGeneration> manualList, LottoGeneration lottoGeneration) {
        List<Lotto> lottoList = new ArrayList<>();

        addManualLotto(manualList, lottoList);

        addAutoLotto(autoQuantity.find(), lottoGeneration, lottoList);

        this.lottos = lottoList;
    }

    private void addAutoLotto(int quantity, LottoGeneration lottoGeneration, List<Lotto> lottoList) {
        for (int i = 0; i < quantity; i++) {
            lottoList.add(new Lotto(lottoGeneration.generate()));
        }
    }

    private void addManualLotto(List<LottoGeneration> manualList, List<Lotto> lottoList) {
        for (LottoGeneration manualGeneration : manualList) {
            lottoList.add(new Lotto(manualGeneration.generate()));
        }
    }

    public List<Lotto> find(){
        return Collections.unmodifiableList(lottos);
    }


    public Map<LottoRank,Integer> findRanks(Lotto winLotto, LottoNumber bonus) {
        Map<LottoRank,Integer> map = new EnumMap<>(LottoRank.class);

        for(Lotto lotto : lottos){
            LottoRank lottoRank = lotto.findRank(winLotto,bonus);
            map.put(lottoRank, map.getOrDefault(lottoRank,0)+1);
        }
        return map;
    }
}
