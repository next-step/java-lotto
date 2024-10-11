package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {
    private static final BigDecimal UNIT_AMOUNT = new BigDecimal(1000);
    private List<Lotto> lottoList;
    private int count;

    public Buyer(int count, LottoNumberGenerator generator) {
        initMember(initLotte(generator.genLottoNumbers(count)));
    }


    public Buyer(List<Lotto> lottoList) {
        initMember(lottoList);
    }

    private void initMember(List<Lotto> lottoList) {
        this.count = lottoList.size();
        this.lottoList = lottoList;
    }
    private List<Lotto> initLotte(List<List<Integer>> lists) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> lottoNum : lists) {
            lottos.add(new Lotto(lottoNum));
        }
        return lottos;
    }

    public BigDecimal getRateOfReturn(List<Integer> winningNumbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Lotto lt : this.lottoList) {
            LottoRankingEnum rank = lt.getRanking(winningNumbers);
            sum = sum.add(rank.getWinningAmount());
        }

        BigDecimal totalPayAmmout = UNIT_AMOUNT.multiply(new BigDecimal(this.count));

        return sum.divide(totalPayAmmout, 2, RoundingMode.DOWN);
    }

    public Map<LottoRankingEnum, Integer> getWinningResult(List<Integer> winningNumbers) {
        Map<LottoRankingEnum, Integer> winningResult = new HashMap<>();
        for (Lotto lt : lottoList) {
            addResult(lt.getRanking(winningNumbers), winningResult);
        }
        return winningResult;
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

    public List<Lotto> getLottos() {
        return this.lottoList;
    }

}
