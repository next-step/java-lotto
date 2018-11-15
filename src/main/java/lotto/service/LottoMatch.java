package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;
import lotto.utils.MatchUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMatch {

    private static final int MATCH_MINIMUM_STANDARD = 3;


    private Map<Rank,Integer> match;
    private WinningLotto winnersNum;

    public LottoMatch(WinningLotto winnersNum){
        match = Stream.of(Rank.values())
                .collect(Collectors.toMap(
                        e -> e
                        ,e -> 0
                ));
        this.winnersNum = winnersNum;
    }

    public Map<Rank, Integer> getMatch() {
        return match;
    }

    //return형식을 WinningLotto로 바꾸어야함
    public Rank getRankFromDuplicateCount(List<Integer> lotto , WinningLotto winnersNum){
        lotto.addAll(winnersNum.getWinnerNums());
        lotto.add(winnersNum.getBonusNum());
        System.out.println("lotto size : " + lotto.size());
        int numOfDuplicate = MatchUtils.getDuplicateCount(lotto);
        System.out.println("중복갯수 : " + numOfDuplicate);

        if(MatchUtils.isContains(MatchUtils.getDuplicateNums(lotto),winnersNum.getBonusNum())){
            return findSecond(numOfDuplicate);
        }
        return Rank.valueOf(numOfDuplicate , false);
    }

    public Map<Rank, Integer> getMatchNum(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            Rank rank = getRankFromDuplicateCount(lotto.getLotto(),winnersNum);
            if(rank.getMatch() >= MATCH_MINIMUM_STANDARD)
                match.put(rank,MatchUtils.pluscount(match.get(rank)));
        }

        return match;
    }

    private Rank findSecond(int numOfDuplicate){
        if(numOfDuplicate == Rank.SECOND.getMatch())
            return Rank.valueOf(numOfDuplicate,true);
        return Rank.valueOf(numOfDuplicate-1,false);

    }


}
