package lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int equalNumberCount(LottoNumbers lottoNumbers) {
        return (int) numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
