package step2.domain.lotto;

import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String LIMIT_NUMBER_EXCEPTION = "로또번호는 1~45까지의 숫자만 올 수 있습니다.";
    private static final String MIN_SIZE_EXCEPTION = "로또번호는 6개여야 합니다.";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(MIN_SIZE_EXCEPTION);
        }
    }

    public static Lotto create(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateLottoNumbers(number);
        }
    }

    private void validateLottoNumbers(Integer number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(LIMIT_NUMBER_EXCEPTION);
        }
    }

    public int correctCount(List<Integer> numbers) {
        return (int) this.lottoNumbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public List<Integer> numbers() {
        return lottoNumbers;
    }

}
