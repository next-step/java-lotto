package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getPriceTotal() {
        return Lotto.PRICE * lottos.size();
    }

    public int size() {
        return lottos.size();
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }

    public LottoResults checkResults(WinningNumbers winningNumbers) {
        Map<Rank, Long> results = lottos.stream()
                .map(l -> l.checkResult(winningNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoResults(results);
    }
}
