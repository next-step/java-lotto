package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    private List<Lotto> getAllLotto() {
        return lottos;
    }

    public void addAll(Lottos lottos) {
        this.lottos.addAll(lottos.getAllLotto());
    }

    public LottoResults checkResults(WinningNumbers winningNumbers, int bonusNumber) {
        Map<Rank, Long> results = lottos.stream()
                .map(l -> l.checkResult(winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoResults(results);
    }
}
