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

    public int match(Lotto winningLotto) {
        return (int) lotto.stream()
                .filter(winningLotto.lotto::contains)
                .count();
    }
}
