package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void makeNumbers() {
        List<Integer> list = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        mapLottoNumbers(list.subList(0, 6));
        sortNumbers();
    }

    public int countMatchingWinningLotto(Lotto lotto) {
        int count = 0;
        for (LottoNumber number : lotto.numbers()) {
            count += containsWinningNumber(number);
        }
        return count;
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
