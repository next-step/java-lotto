package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private List<LottoNumber> numbers;

    public Lotto() {}

    public Lotto(List<Integer> numbers) {
        mapLottoNumbers(numbers);
        sortNumbers();
    }

    private void mapLottoNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        for (Integer number : numbers) {
            this.numbers.add(new LottoNumber(number));
        }
    }

    public List<LottoNumber> numbers() {
        return numbers;
    }

    public int size() {
        return numbers.size();
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    public int countMatchingWinningLotto(Lotto lotto) {
        int count = 0;
        for (LottoNumber number : lotto.numbers()) {
            count += containsWinningNumber(number);
        }
        return count;
    }

    public boolean matchBonusNumber(LottoNumber bonus) {
        return numbers.contains(bonus);
    }


    private int containsWinningNumber(LottoNumber lottoNumber) {
        if (numbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
