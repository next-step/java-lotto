package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    public static final int MAX_LOTTO_NUM_COUNT = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    private List<Integer> numbers;

    public LottoNumber() {
        this.numbers = publishLottoNumber();
    }

    public LottoNumber(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private List<Integer> publishLottoNumber() {
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

    void validateLottoNumbers(List<Integer> lottoNumbers) throws IllegalArgumentException {
        for (Integer lottoNumber : lottoNumbers) {
            checkLottoNumberRange(lottoNumber);
        }
    }

    void checkLottoNumberRange(Integer lottoNumber) throws IllegalArgumentException {
        if (MIN_LOTTO_NUM > lottoNumber || MAX_LOTTO_NUM < lottoNumber) {
            throw new IllegalArgumentException("1부터 45사이의 숫자만 로또숫자로 인정이 됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
