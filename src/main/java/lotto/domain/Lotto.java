package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lottoGame;

    public Lotto(List<Integer> lottoGame) {
        this.lottoGame = lottoGame;
    }

    public static Lotto from(String[] numbers) {
        return new Lotto(Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public int size() {
        return lottoGame.size();
    }

    public List<Integer> getValue() {
        return Collections.unmodifiableList(lottoGame);
    }

    public int getMatchNumberCount(Lotto winningNumber) {
        return (int) lottoGame.stream()
                .filter(value -> winningNumber.getLottoGame().contains(value))
                .mapToInt(Integer::intValue)
                .count();
    }

    private List<Integer> getLottoGame() {
        return lottoGame;
    }
}
