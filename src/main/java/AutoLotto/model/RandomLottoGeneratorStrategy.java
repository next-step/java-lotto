package autoLotto.model;

import java.util.Collections;
import java.util.List;

public class RandomLottoGeneratorStrategy implements LottoGeneratorStrategy {
    @Override
    public int[] lottoGenerator(List<Integer> lotto) {
        shuffleRandomNumbers(lotto);
        return getSixNumbers(lotto);
    }

    private void shuffleRandomNumbers(List<Integer> lotto) {
        Collections.shuffle(lotto);
    }

    private int[] getSixNumbers(List<Integer> lotto) {
        int[] result = new int[6];

        for (int i = 0, j = 0; i < 6; i++, j++) {
            result[j] = lotto.get(i);
        }

        return result;
    }
}
