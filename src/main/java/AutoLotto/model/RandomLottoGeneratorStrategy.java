package AutoLotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGeneratorStrategy implements LottoGeneratorStrategy {
    @Override
    public List<Integer> lottoGenerator(List<Integer> lotto) {
        shuffleRandomNumbers(lotto);
        return getSixNumbers(lotto);
    }

    private void shuffleRandomNumbers(List<Integer> lotto) {
        Collections.shuffle(lotto);
    }

    private List<Integer> getSixNumbers(List<Integer> lotto) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            result.add(lotto.get(i));
        }

        return result;
    }
}
