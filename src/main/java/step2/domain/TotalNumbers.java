package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TotalNumbers {

    private final List<Integer> numberList = new ArrayList<>();

    private static final int MAX_SIZE = 6;
    private static final int MIN_SIZE = 0;

    public TotalNumbers() {
        for (int i = 1; i <= 45; i++) {
            this.numberList.add(i);
        }
    }

    public List<Integer> getRandomLottoNumber() {
        Collections.shuffle(numberList);
        List<Integer> lottoNumber = numberList.subList(MIN_SIZE, MAX_SIZE);
        Collections.sort(lottoNumber);

        return lottoNumber;
    }
}
