package step2.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int[]... lottosnumbers) {
        this(Arrays.stream(lottosnumbers)
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public EnumMap<LottoRank, Long> calculateTotalRank(WinningLotto winnerLotto) {
        return new EnumMap<>(lottos.stream()
                .map(lotto -> LottoRank.findLottoRankByMatchCountAndMatchBonus(winnerLotto.compareToMatchNumberCount(lotto), winnerLotto.checkBonusNumber(lotto)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public int getPurchaseLottoSize() {
        return lottos.size();
    }
}
