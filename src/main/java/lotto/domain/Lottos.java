package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;


    public Lottos(List<LottoNumbers> lottoNumbersList) {
        this.lottos = initLottos(lottoNumbersList);
    }

    public Lottos() {
        this.lottos = new ArrayList<Lotto>();
    }


    private static List<Lotto> initLottos(List<LottoNumbers> numberList) {
        return numberList.stream().map(lottoNum -> new Lotto(lottoNum)).collect(Collectors.toList());
    }

    public void addLottos(List<Lotto> addedLottos) {
        lottos.addAll(addedLottos);
    }

    public void addLottos(Lottos addedLottos) {
        lottos.addAll(addedLottos.lottos);
    }

    public WinningResult getWinningResult(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        for (Lotto lt : lottos) {
            winningResult.addResult(LottoRankEnum.getRank(winningLotto.getMatchCount(lt), winningLotto.isBonusMatch(lt)));
        }
        return winningResult;
    }

    public List<Lotto> asList() {
        return lottos;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottos.stream().map(lotto -> lotto.getLottoNumbers()).collect(Collectors.toList());
    }

}
