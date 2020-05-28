package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final String SPLIT_REGX = ",";

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

    public static Lotto valueOf(String lottoText) {
        String[] winningNumberText = lottoText.split(SPLIT_REGX);
        List<Integer> lottoNumber = Arrays.stream(winningNumberText)
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        return new Lotto(lottoNumber);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

    private int addContainsCount(int currentCount, Integer number) {
        return lottoNumbers.contains(number) ? currentCount + 1 : currentCount;
    }

    public int getContainCount(List<Integer> numbers) {
        int count = 0;
        for(Integer number : numbers) {
            count = addContainsCount(count, number);
        }
        return count;
    }

    private void validateLottoNumberDuplicate(final List<Integer> lottoNumbers) {
        if(lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
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

    @Override
    public String toString() {
        List<String> lottoNumberText = lottoNumbers.stream().map(String::valueOf).collect(Collectors.toList());
        return "[" + String.join(", ", lottoNumberText) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
