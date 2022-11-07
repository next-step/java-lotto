package lotto.lotto;

import lotto.utils.StringToListIntegerConverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinNumbers {
    final List<Integer> numbers;

    private LottoWinNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoWinNumbers of(String numbersString) {
        List<Integer> numbers = StringToListIntegerConverter.convert(numbersString);
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(numbers);
        lottoWinNumbers.validate();
        return lottoWinNumbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void validate() throws IllegalArgumentException {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < 6) {
            throw new IllegalArgumentException("중복된 숫자 입력 불가");
        }
    }
}
