package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame() {
        this.lottos = new ArrayList<>();
    }

    public LottoGame(LottoGenerator lottoNumberRandom) {
        this();
        this.lottos.addAll(lottoNumberRandom.generate());
    }

    public LottoGame addManual(List<String> manualLottos){
        this.lottos.addAll(manualLottos.stream()
                .map(LottoManual::of)
                .collect(Collectors.toList()));
        return this;
    }

    public LottoResult result(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : this.lottos) {
            int match = winningLotto.getWinLotto().match(lotto);
            boolean matchBouns = lotto.contains(winningLotto.getBounsNumber());
            result.putRank(Rank.getRank(match, matchBouns));
        }
        return result;
    }

    List<Lotto> getLottos() {
        return this.lottos;
    }
}
