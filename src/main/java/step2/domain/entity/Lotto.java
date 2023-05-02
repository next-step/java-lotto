package step2.domain.entity;

import step2.domain.vo.Number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<Number> lottoNumbers;

    public Lotto(List<Number> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(int... numbers) {
        this.lottoNumbers = Arrays.stream(numbers)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    private Lotto(String number) {
        this.lottoNumbers = toLottoNumbers(split(number));
    }

    public static Lotto winner(String number) {
        return new Lotto(number);
    }

    private String[] split(String number) {
        return number.split(",");
    }

    private List<Number> toLottoNumbers(String[] numbers) {
        validateLottoNumbers(numbers);

        return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(String[] numbers) {
        if (numbers.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
