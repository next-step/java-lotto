package lotto.domain;

import java.util.*;

import static java.util.Collections.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return unmodifiableList(lottos);
    }

    public LottoResult getLottoResult(WinningLotto lastWinningLotto) {
        return new LottoResult(createLottoResult(lastWinningLotto));
    }

    public double calculateProfitability(LottoResult lottoResult, double amount) {
        Map<LottoRank, Integer> resultMap = lottoResult.getResultMap();
        int profit = 0;
        for (Map.Entry<LottoRank, Integer> entry : resultMap.entrySet()) {
            LottoRank lottoRank = entry.getKey();
            Integer integer = entry.getValue();
            profit += lottoRank.getWinningPrize() * integer;
        }
        return profit / amount;
    }

    private Map<LottoRank, Integer> createLottoResult(WinningLotto lastWinningLotto) {
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lastWinningLotto.findRank(lotto);
            resultMap.put(lottoRank, resultMap.getOrDefault(lottoRank, 0) + 1);
        }
        resultMap.remove(LottoRank.ETC);
        return resultMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
