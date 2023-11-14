package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public int size(){
        return lottoList.size();
    }

    public List<String> find(){
        List<String> list = new ArrayList<>();
        for(Lotto lotto : lottoList){
            list.add(lotto.findNumbersExtract());
        }
        return list;
    }


    public Map<LottoRank, Integer> findMatchNumbers(List<Integer> winList) {
        Map<LottoRank,Integer> resultMap = new EnumMap<>(LottoRank.class);
        for(Lotto lotto : lottoList){
            LottoRank lottoRank = LottoRank.findMatchNumber(lotto.countMatchNumber(winList));
            resultMap.put(lottoRank, resultMap.getOrDefault(lottoRank, 0)+1);
        }
        return resultMap;
    }
}