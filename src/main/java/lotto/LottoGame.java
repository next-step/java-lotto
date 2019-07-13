package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(Money money, LottoGenerator lottoNumberRandom, List<String> manualLottos) {
        this.lottos = manualLottos.stream()
                .map(Lotto::of)
                .collect(Collectors.toList());
        this.lottos.addAll(lottoNumberRandom.generate(money));
    }

    public LottoResult result(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int match = winningLotto.getWinLotto().match(lotto);
            boolean matchBouns = lotto.contains(winningLotto.getBounsNumber());
            result.putRank(Rank.getRank(match, matchBouns));
        }
        return result;
    }

    List<Lotto> getLottos() {
        return lottos;
    }
}
