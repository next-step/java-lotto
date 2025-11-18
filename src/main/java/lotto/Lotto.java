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

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public static Lotto from(List<Integer> intNumbers) {
        return new Lotto(createLottoNumbers(intNumbers));
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 총 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    private List<LottoNumber> sortNumbers(List<LottoNumber> numbers) {
        List<LottoNumber> sorted = new ArrayList<>(numbers);
        sorted.sort(Comparator.comparingInt(LottoNumber::getValue));
        return sorted;
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
        return numbers.contains(number);
    }

}
