package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.shuffle;

public class Lotto {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 46;
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> createNumber() {
        generateLottoNumber();
        shuffle(list);

        return list;
    }

    private void generateLottoNumber() {
        for (int i = START_LOTTO_NUMBER; i < END_LOTTO_NUMBER; i++) {
            list.add(i);
        }
    }
}
