package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private int[] lottoNumbers;

    public Lotto() {
        this.lottoNumbers = creteLottoNumbers();
    }

    private int[] creteLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        int[] result = new int[6];
        for (int i = 0; i < 6; i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }
}
