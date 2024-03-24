package lotto.interf;

import lotto.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoStrategy implements LottoStrategy {
    private static final int LOTTO_ELEMENT =6;
    private final RandomGenerator randomGenerator;

    public RandomLottoStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public List<Integer> genLotto(){
        List<Integer> lotto = new ArrayList<>();

        while (lotto.size() != LOTTO_ELEMENT) {
            lotto = addLottoNum(lotto, randomGenerator.genRandomNum());
        }
        return lotto;
    }
    private List<Integer> addLottoNum(List<Integer> lotto, int element){
        if (!lotto.contains(element)) {
            lotto.add(element);
        }
        return lotto;
    }

}
