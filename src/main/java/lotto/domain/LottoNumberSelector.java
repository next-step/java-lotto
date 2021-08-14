package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumberSelector {

    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final List<Integer> numbers = Arrays.asList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
        21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
        41, 42, 43, 44, 45);

    public static List<Integer> selectNumbers() {
        List<Integer> selectedNumbers = new ArrayList<>();
        Collections.shuffle(numbers);
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            selectedNumbers.add(numbers.get(i));
        }
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

}
