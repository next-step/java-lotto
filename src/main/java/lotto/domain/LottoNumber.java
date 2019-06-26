package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    public static final int MAX_LOTTO_NUM_COUNT = 6;
    static final int MIN_LOTTO_NUM = 1;
    static final int MAX_LOTTO_NUM = 45;

    private List<Integer> numbers;

    public LottoNumber() {
        this.numbers = publishLottoNumbers();
    }

    private List<Integer> publishLottoNumbers() {
        List<Integer> lottoAllNumbers = createLottoAllNumbers();
        List<Integer> lottoNums = new ArrayList();
        for (int index = 0; index < MAX_LOTTO_NUM_COUNT; index++) {
            lottoNums.add(lottoAllNumbers.get(index));
        }
        Collections.sort(lottoNums);
        return lottoNums;
    }

    List<Integer> createLottoAllNumbers() {
        List<Integer> numbers = new ArrayList();
        for (int lottoNum = MIN_LOTTO_NUM; lottoNum <= MAX_LOTTO_NUM; lottoNum++) {
            numbers.add(lottoNum);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
