package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class LottoNumbers {

    private static final int MAX_SIZE = 7;
    private static final String CHECK_SIZE = "6개의 숫자까지만 담을 수 있습니다.";

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new TreeSet<>();
    }

    public LottoNumbers(List<Integer> numbers) {
        if (!isAddAvailableInput(numbers)) {
            throw new IllegalArgumentException(CHECK_SIZE);
        }
        this.lottoNumbers = new TreeSet<>();
        addNumbers(numbers);
    }

    private void addNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    private boolean isAddAvailableInput(List<Integer> numbers) {
        return numbers.size() < MAX_SIZE;
    }

    public void addNumber(LottoNumber lottoNumber) {

        if (!isAddAvailable()) {
            throw new IllegalArgumentException(CHECK_SIZE);
        }

        lottoNumbers.add(lottoNumber);
    }

    private boolean isAddAvailable() {
        return lottoNumbers.size() < MAX_SIZE;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<Integer> numbers() {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber number : lottoNumbers) {
            result.add(number.number());
        }

        return result;
    }

    public int countWinning(LottoNumbers victoryNumber) {
        int result = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            result = compareTwoNumber(victoryNumber, lottoNumber, result);
        }
        return result;
    }

    private int compareTwoNumber(LottoNumbers victoryNumber,
            LottoNumber lottoNumber, int result) {

        return victoryNumber.hasNumber(lottoNumber) ? result + 1 : result;
    }

    private boolean hasNumber(LottoNumber inputNumber) {
        boolean result = false;
        for (LottoNumber lottoNumber : lottoNumbers) {
            result = isEqualsNumber(inputNumber, result, lottoNumber);
        }
        return result;
    }

    private boolean isEqualsNumber(LottoNumber inputNumber, boolean result,
            LottoNumber lottoNumber) {

        if (!result && lottoNumber.equals(inputNumber)) {
            result = true;
        }

        return result;
    }

}
