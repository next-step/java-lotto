package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {


    private List<PickNumbers> lottoNumbers;

    public Lottos(List<PickNumbers> lottos) {
        lottoNumbers = lottos;
    }

    public Map<Integer, Integer> aggregate(LottoNumbers winnerNumbers) {

//        Map<Integer, Integer> map = new HashMap<>();
//        for (LottoNumbers lottoNumber : lottoNumbers) {
//            int matchCount = lottoNumber.compare(winnerNumbers);
//            Integer integer = map.get(matchCount);
//            if(integer == null) {
//                map.put(matchCount, 1);
//            }
//            else {
//                integer++;
//                map.put(matchCount, integer);
//            }
//        }
        return null;
    }
}
