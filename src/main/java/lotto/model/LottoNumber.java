package lotto.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private Integer lottoNumber;
    public LottoNumber(Integer number) {
        checkRange(number);
        this.lottoNumber = number;
    }

    public LottoNumber() {

    }
    private List<Integer> numberList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i=MINIMUM_NUMBER; i<=MAXIMUM_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private List<Integer> shuffleLottoNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private List<Integer> cuttingLottoNumbers(List<Integer> numbers) {
        List<Integer> lottoNumbers = numbers.subList(0,6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> pickLotto() {
        return cuttingLottoNumbers(shuffleLottoNumbers(numberList()));
    }

    private void checkRange(Integer number) {
        if (number>45 || number<1) {
            throw new IllegalArgumentException("로또 숫자의 범위가 올바르지 않았습니다.");
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }


}
