package lotto.domain;

import java.util.Set;

public class Lotto {
    public static final int SIZE_LIMIT = 6;
    public static final int UNIT_PRICE = 1_000;
    private Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        if (isNotSizeSix(numbers)) {
            throw new IllegalArgumentException("로또는 6개의 숫자로만 구성됩니다.");
        }
        this.numbers = numbers;
    }

    private boolean isNotSizeSix(Set<LottoNumber> numbers) {
        return numbers.size() != SIZE_LIMIT;
    }

    public int countNumberOfMatch(Lotto anotherLotto) {
        return (int) numbers
                .stream()
                .filter(number -> anotherLotto.numbers.contains(number))
                .count();
    }

    public boolean hasBonusBall(LottoNumber bonusBall) {
        return numbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    @Override
    public String toString() {
        return numbers + "";
    }

    public String getNumbers() {
        return numbers + "";
    }
}
