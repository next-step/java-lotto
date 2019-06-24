package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getCount() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        return this.lottos.toString();
    }

    public List<Integer> getCountOfMatchingNumbers(List<Integer> winningNumbers) {
        return lottos.stream()
                .mapToInt(lotto -> lotto.hasHowMany(winningNumbers))
                .boxed()
                .collect(Collectors.toList());
    }

    public int getUsedAmount() {
        return Lotto.price * this.lottos.size();
    }
}
