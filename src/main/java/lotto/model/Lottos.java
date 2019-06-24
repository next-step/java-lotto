package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {


    private List<PickNumbers> lottoNumbers;

    public Lottos(List<PickNumbers> lottos) {
        lottoNumbers = lottos;
    }

    public Map<Long, Integer> aggregate(WinningNumbers winnerNumbers) {

        Map<Long, Integer> map = new HashMap<>();
        for (PickNumbers pickNumbers : lottoNumbers) {
            long matchCount = pickNumbers.compare(winnerNumbers);
            Integer integer = map.get(matchCount);
            if(integer == null) {
                map.put(matchCount, 1);
            }
            else {
                integer++;
                map.put(matchCount, integer);
            }
        }
        return map;
    }
}
