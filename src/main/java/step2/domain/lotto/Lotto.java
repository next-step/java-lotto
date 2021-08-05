package step2.domain.lotto;

import java.util.List;

public class Lotto {

    private static final String NEGATIVE_NUMBER_EXCEPTION = "로또번호에 음수는 올 수 없습니다.";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private void validateLottoNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
            }
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
