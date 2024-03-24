package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lotto;

    public Lotto(List<Integer> lottoGame) {
        this.lotto = lottoGame;
    }

    public static Lotto from(String[] numbers) {
        return new Lotto(Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public int size() {
        return lotto.size();
    }

    public List<Integer> getValue() {
        return Collections.unmodifiableList(lotto);
    }

    public int getMatchNumberCount(Lotto winningNumber) {
        return (int) lotto.stream()
                .filter(value -> winningNumber.getLotto().contains(value))
                .mapToInt(Integer::intValue)
                .count();
    }

    private List<Integer> getLotto() {
        return lotto;
    }
}
