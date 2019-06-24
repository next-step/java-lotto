package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    static final int MIN_LOTTO_NUM = 1;
    static final int MAX_LOTTO_NUM = 45;
    static final int MAX_LOTTO_NUM_COUNT = 6;
    static final int AMOUNT = 1000;

    private List<Integer> numbers;

    public Lotto() {
        this.numbers = publishNumbers();
    }

    private List<Integer> publishNumbers() {
        List numbers = new ArrayList();
        for (int lottoNum = MIN_LOTTO_NUM; lottoNum <= MAX_LOTTO_NUM; lottoNum++) {
            numbers.add(lottoNum);
        }
        Collections.shuffle(numbers);
        List lottoNums = new ArrayList();
        for (int index = 0; index < MAX_LOTTO_NUM_COUNT; index++) {
            lottoNums.add(numbers.get(index));
        }
        Collections.sort(lottoNums);
        return lottoNums;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
