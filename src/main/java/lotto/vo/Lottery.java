package lotto.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {

    private final Set<Integer> lotto;

    public Lottery(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    public static Lottery toLotteries(List<Integer> lotteryNumbers) {
        Set<Integer> lotto = new HashSet<>();
        for (Integer number : lotteryNumbers) {
            lotto.add(number);
        }
        return new Lottery(lotto);
    }

    public int containsCount(Lottery userLotto) {
        int count = 0;
        for(Integer number : userLotto.lotto){
            if(lotto.contains(number)){
                count+=1;
            }
        }
        return count;
    }
}
