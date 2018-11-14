package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.LottoEnum;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMatch {

    private static final int MATCH_MINIMUM_STANDARD = 3;
    private static final int MAX_LENGTH_AFTER_DISTINCT = 12;

    private Map<LottoEnum,Integer> match;
    private List<Integer> winnersNums;

    public LottoMatch(List<Integer> winnersNums){
        match = Stream.of(LottoEnum.values())
                .collect(Collectors.toMap(
                        e -> e
                        ,e -> 0
                ));
        this.winnersNums = winnersNums;
    }


    public Map<LottoEnum, Integer> getMatch() {
        return match;
    }

    private int pluscount(int currentCount){
        return ++currentCount;
    }

    public static int duplicatedCounts(List<Integer> lotto , List<Integer> winnersNum){
        lotto.addAll(winnersNum);

        return MAX_LENGTH_AFTER_DISTINCT - (int) lotto.stream()
                .distinct()
                .count();
    }

    public Map<LottoEnum, Integer> getMatchNum(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            int duplicateTemp = duplicatedCounts(lotto.getLotto(),winnersNums);
            if(duplicateTemp >= MATCH_MINIMUM_STANDARD)
                match.put(getEnumMatch(duplicateTemp),pluscount(match.get(getEnumMatch(duplicateTemp))));
        }

        return match;
    }

    public static LottoEnum getEnumMatch(int duplicateNums){
        return LottoEnum.values()[duplicateNums-3];
    }


}
