package lotto.domain;

import lotto.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int MIN_ELEMENT = 1;
    private static final int MAX_ELEMENT = 45;

    private List<Integer> lotto = new ArrayList<>();
    private int count = 0;

    public Lotto(){
    }

    public Lotto(List<Integer> lotto){
        if(lotto.size()!=6){
            throw new IllegalArgumentException("로또는 6개 원소 필요");
        }

        for(int element : lotto){
            checkBound(element);
        }

        if(lotto.size() != lotto.stream().distinct().count()){
            throw new IllegalArgumentException("로또는 원소 중복 불가");
        }

        this.lotto = lotto;
    }

    private void checkBound(int input){
        if(input < MIN_ELEMENT || input > MAX_ELEMENT){
            throw new IllegalArgumentException("로또는 1~45 사이 원소 사용");
        }
    }

    public RankMatches numMatch(Lotto picked){
        for(int element: picked.getLotto()){
            checkMatch(element);
        }
        return RankMatches.makeRank(count);
    }

    private void checkMatch(int element) {
        if(this.lotto.contains(element)){
            this.count = this.count + 1;
        }
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
