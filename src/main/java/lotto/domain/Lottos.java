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

    public LottoRankGroup getRankGroup(LottoNumbers winningLottoNumber) {
        List<LottoRank> lottoRanks = new ArrayList<>();

        for (Lotto each : lottos) {
            lottoRanks.add(each.getRank(winningLottoNumber));
        }

        Map<LottoRank, Long> rankGroup = lottoRanks
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoRankGroup(rankGroup);
    }

    public List<Lotto> getValue() {
        return new ArrayList<>(lottos);
    }

    public int size() {
        return lottos.size();
    }
}
