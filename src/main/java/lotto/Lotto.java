package lotto;

import java.util.List;

public class Lotto {
    public static final int SIZE_LIMIT = 6;
    public static final int UNIT_PRICE = 1_000;
    protected List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
        if (isNotSizeSix(numbers)) {
            throw new IllegalArgumentException("로또는 6개의 숫자로만 구성됩니다.");
        }
        this.numbers = numbers;
    }

    private boolean hasDuplicate(List<LottoNumber> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isNotSizeSix(List<LottoNumber> numbers) {
        return numbers.size() != SIZE_LIMIT;
    }

    public int countNumberOfMatch(WinningLotto anotherLotto) {
        return (int) numbers
                .stream()
                .filter(number -> anotherLotto.getLotto().numbers.contains(number))
                .count();
    }

    public boolean isAnyMatchingBonusBall(WinningLotto winningLotto) {
        return numbers.stream().anyMatch(winningLotto::isMatchingBonusBall);
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
