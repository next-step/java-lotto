package lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;
import static java.util.Collections.sort;

public class Lotto {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private final List<Integer> lottoNumber = new ArrayList<>();

    public List<Integer> execute() {
        generateLottoNumber();

        return lottoNumber;
    }

    private void generateLottoNumber() {
        List<Integer> values = new ArrayList<>();
        makeStartToEndLottoNumber(values);
        shuffle(values);

        lottoNumber.addAll(values.subList(0, 6));

        sort(lottoNumber);
    }

    private static void makeStartToEndLottoNumber(List<Integer> values) {
        for (int i = START_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
            values.add(i);
        }
    }
}
