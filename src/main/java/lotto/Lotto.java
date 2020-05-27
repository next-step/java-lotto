package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateLottoNumberDuplicate(lottoNumbers);
        validateRangeOfNumbers(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

    public int getContainsCount(Integer number) {
        return lottoNumbers.contains(number) ? 1 : 0;
    }

    public int getContainCount(List<Integer> numbers) {
        int count = 0;
        for(Integer number : numbers) {
            count += getContainsCount(number);
        }
        return count;
    }

    private void validateLottoNumberDuplicate(final List<Integer> lottoNumbers) {
        int setSize = new HashSet<>(lottoNumbers).size();
        if(lottoNumbers.size() != setSize) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
        }
    }

    private void validateLottoNumberCount(final List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    private void validateRangeOfNumbers(final List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            throwExceptionIfOutOfRange(lottoNumber);
        }
    }

    private void throwExceptionIfOutOfRange(Integer number) {
        if(number < LOTTO_START_NUMBER || number > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이만 올 수 있습니다.");
        }
    }
}
