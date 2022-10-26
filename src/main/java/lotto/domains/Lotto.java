package lotto.domains;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    protected static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 개수는 6개여야 합니다.");
        }

        if (containsDuplicateNumber(lottoNumbers)) {
            throw new IllegalArgumentException("로또 숫자는 중복이 될 수 없습니다. 입력값: " + lottoNumbers);
        }

        this.numbers = new ArrayList<>(lottoNumbers);
    }

    private boolean containsDuplicateNumber(List<LottoNumber> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_NUMBERS_SIZE;
    }

    public Prize getPrize(LottoWinner winner) {
        long count = numbers.stream()
                .filter(num -> winner.contains(num))
                .count();

        boolean bonus = numbers.stream()
                .anyMatch(num -> winner.isBonus(num));

        return Prize.find(count, bonus);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
