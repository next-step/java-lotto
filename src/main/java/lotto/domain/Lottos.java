package lotto.domain;

import lotto.dto.Result;
import lotto.utils.LottoCountCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(int amount) {
        lottoList = new ArrayList();

        for (int i=0; i< LottoCountCalculator.calculateQuantity(amount); i++){
            lottoList.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> inLottoList){
        lottoList = inLottoList;
    }

    public Result getWinningResult(WinningLotto winningLotto) {
        Result result = new Result();

        List<Rank> rankList = getRankList(winningLotto);
        rankList.forEach(result::put);

        return result;
    }

    private List<Rank> getRankList(WinningLotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> winningLotto.countMatchingWith(lotto))
                .map(count -> Rank.rankOf(count))
                .filter(rank -> rank != Rank.NON_RANKED)
                .collect(Collectors.toList());
    }

    public int count() {
        return lottoList.size();
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(lotto -> lotto.toString())
                .collect(Collectors.joining("\n"));
    }
}
