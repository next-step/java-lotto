package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = createLottoNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 총 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        Collections.sort(lottoNumbers, Comparator.comparingInt(LottoNumber::getValue));
        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber number : numbers) {
            result.add(number.getValue());
        }
        return result;
    }

    public int countMatchNumber(Lotto other) {
        int count = 0;
        for (LottoNumber number : numbers) {
            if (other.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean contains(LottoNumber number) {
        for (LottoNumber lottoNumber : numbers) {
            if (lottoNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }

}
