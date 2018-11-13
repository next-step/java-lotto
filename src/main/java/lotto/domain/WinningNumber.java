package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningNumber {

    private List<Lotto> lottos;
    private List<Integer> numbers;

    public WinningNumber(List<Lotto> lottos, List<Integer> numbers) {
        this.lottos = lottos;
        this.numbers = numbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Lotto> filter(final int matchNumber) {
        return this.lottos.stream().filter(lotto -> lotto.isMatchNumber(this.numbers, matchNumber)).collect(toList());
    }

}
