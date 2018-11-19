package lotto.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto{

    private Lotto lotto;
    private int bonusNum;

    public WinningLotto(Lotto lotto, int bonusNum) {
        if(bonusNum < 1 || bonusNum > 45 ){
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
