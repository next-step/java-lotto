package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= Lotto.LOTTO_MAX_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        System.out.println(numbers.subList(0, Lotto.LOTTO_SIZE));
        return numbers.subList(0, Lotto.LOTTO_SIZE);
    }
}
