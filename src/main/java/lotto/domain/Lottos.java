package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = createLottos(count);
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public Map<LottoRank, Long> getRankGroup(Lotto winningLotto) {
        List<LottoRank> lottoRanks = new ArrayList<>();

        for (Lotto each : lottos) {
            lottoRanks.add(each.getRank(winningLotto));
        }

        return lottoRanks.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }
}
