package lotto.dto;

import lotto.utils.LottoMaker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto{

    private static final int MIN_OF_LOTTO = 1;
    private static final int MAX_OF_LOTTO = 45;
    private Lotto lotto;
    private int bonusNum;

    public WinningLotto(Lotto lotto, int bonusNum) {
        if(bonusNum < MIN_OF_LOTTO || bonusNum > MAX_OF_LOTTO ){
            throw new IllegalArgumentException("bonusNum in not in boudary");
        }
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    public Rank matchOf(Lotto boughntLotto) {
        int matchingCount = lotto.match(boughntLotto);
        boolean matchingBonus = boughntLotto.contains(bonusNum);
        return Rank.valueOf(matchingCount,matchingBonus);
    }

    public Map<Rank,Integer> match(List<Lotto> gamePlays) {
        Map<Rank,Integer> maps = initailize();
        for (int i = 0 ; i < gamePlays.size() ; i ++){
            Rank rank = matchOf(gamePlays.get(i));
            maps.put(rank,maps.get(rank)+1);
        }

        return maps;
    }

    public Map<Rank,Integer> initailize(){
        return Stream.of(Rank.values())
                .collect(Collectors.toMap(
                        e -> e
                        ,e -> 0
                ));
    }
}
