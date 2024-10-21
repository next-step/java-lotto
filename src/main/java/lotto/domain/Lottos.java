package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<LottoNumbers> lottoNumbersList) {
        this.lottos = initLottos(lottoNumbersList);
    }

    private static List<Lotto> initLottos(List<LottoNumbers> numberList) {
        return numberList.stream().map(lottoNum -> new Lotto(lottoNum)).collect(Collectors.toList());
    }

    public WinningResult getWinningResult(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        for (Lotto lt : lottos) {
            winningResult.addResult(LottoRankEnum.getRank(winningLotto.getMatchCount(lt), winningLotto.isBonusMatch(lt)));
        }
        return winningResult;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottos.stream().map(lotto -> lotto.getLottoNumbers()).collect(Collectors.toList());
    }

}
