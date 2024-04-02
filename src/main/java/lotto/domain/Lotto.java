package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public void validateNumbers(List<LottoNumber> numbers) {
        validateEmpty(numbers);
        validateSize(numbers);
        validateIfDuplication(numbers);
    }

    private void validateEmpty(List<LottoNumber> numbers) {
        if(numbers == null){
            throw new IllegalArgumentException("로또 숫자들은 null이 아니어야 합니다.");
        }
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6자리 숫자들이어야 합니다.");
        }
    }

    private void validateIfDuplication(List<LottoNumber> numbers) {
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != count) {
            throw new IllegalArgumentException("로또 숫자들은 서로 중복일 수 없습니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(new LottoNumber(number));
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
