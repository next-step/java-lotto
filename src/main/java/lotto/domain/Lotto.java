package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Number> lotto;

    public Lotto(String[] numbers) {
        this.lotto = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    public Lotto(List<Number> numbers) {
        this.lotto = numbers;
    }

    public List<Number> getLotto() {
        return lotto;
    }

    public int countNumbers(Lotto otherLotto) {
        int conut = 0;
        for (Number number : lotto) {
            conut += otherLotto.getLotto()
                    .stream()
                    .anyMatch(num -> num.equals(number)) ? 1 : 0;
        }
        return conut;
    }
}
