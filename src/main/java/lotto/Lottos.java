package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int count(){
        return this.lottos.size();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public Map<KLottoRank, Integer> checkWin(WinNumber winNumber) {
        return lottos.stream()
                .map(lotto -> lotto.checkRank(winNumber))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }
}
