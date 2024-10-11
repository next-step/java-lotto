package lotto.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    public static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final Set<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    private LottoNumbers(Set<Integer> lottoNumbers) {
        validateNumberOfLottoNumbers(lottoNumbers);
        validateNumberRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static void validateNumberOfLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() == NUMBER_OF_LOTTO_NUMBERS) {
            return;
        }
        throw new IllegalArgumentException("로또 번호는 6개 입니다.");
    }

    private static void validateNumberRange(Set<Integer> lottoNumbers) {
        boolean isValidNumbers = lottoNumbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);

        if (isValidNumbers) {
            return;
        }
        throw new IllegalArgumentException("로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "까지 입니다.");
    }

    public boolean match(int targetNumber) {
        return lottoNumbers.contains(targetNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }


    public int matchLottoNumbers(LottoNumbers otherNumbers) {
        return (int) lottoNumbers.stream()
                .filter(otherNumbers::match)
                .count();
    }
}
