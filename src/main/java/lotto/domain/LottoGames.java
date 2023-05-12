package lotto.domain;

import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.number.LottoNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoGames {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoGameList = new ArrayList<>();
    private final HashMap<Rank, Integer> lottoResult = new HashMap<>();

    public LottoGames(int gameCount) {
        gameCount /= LOTTO_PRICE;
        for (int i = 0; i < gameCount; i++) {
            lottoGameList.add(new Lotto(new AutoLottoGenerator()));
        }
    }

    public LottoGames(List<Lotto> lottoGameList) {
        this.lottoGameList.addAll(lottoGameList);
    }

    protected int size() {
        return this.lottoGameList.size();
    }

    protected int sum() {
        return lottoResult.keySet().stream()
                .map(rank -> (lottoResult.get(rank) * rank.getPrize()))
                .reduce(0, Integer::sum);
    }

    public double calculateReturn() {
        return sum() / (double) (LOTTO_PRICE * lottoGameList.size());
    }

    public void calculatePrizeCount(WinningLotto winningLotto) {
        lottoGameList.forEach(lotto -> {
            Rank rank = Rank.findRank(lotto.findMatchCount(winningLotto));
            int winningCount = lottoResult.getOrDefault(rank, 0);
            lottoResult.put(rank, ++winningCount);
        });
    }

    public void calculatePrizeCount(WinningLotto winningLotto, LottoNumber bonusLottoNumber) {
        lottoGameList.forEach(lotto -> {
            Rank rank = Rank.findRank(lotto.findMatchCount(winningLotto), lotto.hasBonusLottoNumber(bonusLottoNumber));
            int winningCount = lottoResult.getOrDefault(rank, 0);
            lottoResult.put(rank, ++winningCount);
        });
    }

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }
}
