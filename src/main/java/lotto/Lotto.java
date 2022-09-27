package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto(List<Integer> lottoNum) {
        this.lotto = lottoNum;
    }
    public List<Integer> getLotto() {
        return lotto;
    }

    public long getMatchedCount(List<Integer> input){
        return input.stream().filter((num)->this.lotto.contains(num)).count();
    }

}