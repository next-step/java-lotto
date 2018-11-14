package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.LottoEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatch {

    Map<Integer,Integer> match;
    private List<Integer> winnersNums;

    public LottoMatch(List<Integer> winnersNums){
        match = Arrays.stream(LottoEnum.values())
                .collect(Collectors.toMap(LottoEnum::getMatch, e-> 0));
        this.winnersNums = winnersNums;
    }


    public Map<Integer, Integer> getMatch() {
        return match;
    }

    private int pluscount(int currentCount){
        return ++currentCount;
    }

    public static int duplicatedCounts(List<Integer> lotto , List<Integer> winnersNum){
        lotto.addAll(winnersNum);

        return 12 - (int) lotto.stream()
                .distinct()
                .count();
    }

    public Map<Integer, Integer> getMatchNum(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            int duplicateTemp = duplicatedCounts(lotto.getLotto(),winnersNums);
            if(duplicateTemp >= 3)
            match.put(duplicateTemp,pluscount(match.get(duplicateTemp)));
        }

        return match;
    }


}
