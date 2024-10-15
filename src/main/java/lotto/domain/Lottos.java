package lotto.domain;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final BigDecimal UNIT_AMOUNT = new BigDecimal(1000);
    private final List<Lotto> lottos ;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public BigDecimal getWinningAmount(Lotto winningLotto) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Lotto lotto : this.lottos) {
            LottoRankingEnum rank = lotto.getRanking(winningLotto);
            sum = sum.add(rank.getWinningAmount());
        }
        return sum;
    }

    public Map<LottoRankingEnum, Integer> getWinningResult(Lotto winningLotto) {
        Map<LottoRankingEnum, Integer> winningResult = new HashMap<>();
        for (Lotto lt : lottos) {
            addResult(lt.getRanking(winningLotto), winningResult);
        }
        return winningResult;
    }

    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lt : lottos) {
            lottoNumbers.add(lt.getLottoNumbers());
        }
        return lottoNumbers;
    }

    private void addResult(LottoRankingEnum rankingEnum, Map<LottoRankingEnum, Integer> result) {

        if(LottoRankingEnum.LOSING_LOT.equals(rankingEnum)) {
            return ;
        }
        int count = 1;
        if (result.containsKey(rankingEnum)) {
            result.put(rankingEnum, result.get(rankingEnum) + count);
            return ;
        }
        result.put(rankingEnum, count);
    }

    public BigDecimal getTotalPaymentAmount() {
        return UNIT_AMOUNT.multiply(BigDecimal.valueOf(lottos.size()));
    }

    public int getSize() {
        return lottos.size();
    }

}
