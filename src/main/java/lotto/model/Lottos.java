package lotto.model;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getCount() {
        return this.lottos.size();
    }

    public int getBuyingMoney() {
        return Lotto.PRICE * this.lottos.size();
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(joining(System.lineSeparator()));
    }

    public List<Integer> getCountOfMatchingNumbers(Lotto winningLotto) {
        return this.lottos.stream()
                .mapToInt(lotto -> lotto.getCountOfMatchingNumbers(winningLotto))
                .boxed()
                .collect(toList());
    }

    public List<Prize> matches(WinningLotto winningLotto) {
        return this.lottos.stream().map(lotto -> lotto.matches(winningLotto)).collect(toList());
    }
}
