package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos ;

    public Lottos(List<LottoNumbers> lottoNumbersList) {
        this.lottos = initLottos(lottoNumbersList);
    }

    private static List<Lotto> initLottos(List<LottoNumbers> numberList) {
        return numberList.stream().map(lottoNum -> new Lotto(lottoNum)).collect(Collectors.toList());
    }

    public BigDecimal getWinningAmount(WinningLotto winningLotto) {
        return lottos.stream().map(lotto->lotto.getWinningAmount(winningLotto)).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getRateOfReturn(WinningLotto winningLotto) {
        return getWinningAmount(winningLotto).divide(getTotalPaymentAmount(), 2, RoundingMode.DOWN);
    }

    public Map<LottoRankEnum, Integer> getWinningResult(WinningLotto winningLotto) {
        Map<LottoRankEnum, Integer> winningResult = new HashMap<>();
        for (Lotto lt : lottos) {
            addResult(lt.getRank(winningLotto), winningResult);
        }
        return winningResult;
    }

    private void addResult(LottoRankEnum rankingEnum, Map<LottoRankEnum, Integer> result) {

        if(LottoRankEnum.LOSING_LOT.equals(rankingEnum)) {
            return ;
        }
        int count = 1;
        if (result.containsKey(rankingEnum)) {
            result.put(rankingEnum, result.get(rankingEnum) + count);
            return ;
        }
        result.put(rankingEnum, count);
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottos.stream().map(lotto->lotto.getLottoNumbers()).collect(Collectors.toList());
    }
    public BigDecimal getTotalPaymentAmount() {
        return LottoUnitAmount.getBigDecimalVal().multiply(BigDecimal.valueOf(lottos.size()));
    }
    public int getSize() {
        return lottos.size();
    }
}
