package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> createLotto() {
        List<Integer> newLotto = new ArrayList<>(LottoNumbers.shuffle().subList(0, 6));
        Collections.sort(newLotto);
        return newLotto;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(number -> winningNumbers.getList().contains(number))
                .count();
    }
}
