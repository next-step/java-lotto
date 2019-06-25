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

    public double getBuyingMoney() {
        return Lotto.PRICE * this.lottos.size();
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(joining(System.lineSeparator()));
    }

    public List<Integer> getCountOfMatchingNumbers(List<Integer> winningNumbers) {
        return this.lottos.stream()
                .mapToInt(lotto -> lotto.hasHowMany(winningNumbers))
                .boxed()
                .collect(toList());
    }
}
