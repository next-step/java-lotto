package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getCount() {
        return this.lottos.size();
    }

    public int getUsedAmount() {
        return Lotto.price * this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return this.lottos.stream().map(lotto -> lotto.toString()).collect(Collectors.joining(System.lineSeparator()));
    }

    public List<Integer> getCountOfMatchingNumbers(List<Integer> winningNumbers) {
        return this.lottos.stream()
                .mapToInt(lotto -> lotto.hasHowMany(winningNumbers))
                .boxed()
                .collect(toList());
    }
}
