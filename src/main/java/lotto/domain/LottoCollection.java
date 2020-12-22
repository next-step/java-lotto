package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCollection {
    private final List<Lotto> lottos;

    public LottoCollection(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult getLottoResult(Lotto winnerLotto, LottoNumber bonusNumber, int buyAmount) {
        return new LottoResult(lottos, winnerLotto, bonusNumber, buyAmount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static List<Lotto> concatLottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        return Stream
                .concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
    }
}
