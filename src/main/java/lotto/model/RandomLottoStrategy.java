package lotto.model;


import java.util.Collections;
import java.util.List;

public class RandomLottoStrategy implements LottoStrategy {
    @Override
    public List<Integer> lottoGenerator(List<Integer> lotto) {
        shuffleRandomNumbers(lotto);
        return getSixNumbers(lotto);
    }

    private void shuffleRandomNumbers(List<Integer> lotto) {
        Collections.shuffle(lotto);
    }

    private List<Integer> getSixNumbers(List<Integer> lotto) {
        return lotto.subList(0, 6);
    }

}
