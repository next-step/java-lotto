package lotto.domain;

import lotto.domain.purchaseStrategy.PurchaseStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    private static final String BELOW_MIN_AMOUNT_ERROR_MESSAGE = "최소 1000원 이상 지불하셔야 합니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int INIT_COUNT = 0;

    public Lottos buyLotto(int amount, PurchaseStrategy purchaseStrategy) {
        validateAmount(amount);
        return new Lottos(printLotto(amount, purchaseStrategy));
    }

    private void validateAmount(int amount) {
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(BELOW_MIN_AMOUNT_ERROR_MESSAGE);
        }
    }

    private List<Lotto> printLotto(int amount, PurchaseStrategy purchaseStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = INIT_COUNT; i < amount/LOTTO_PRICE; i++) {
            lottos.add(new Lotto(purchaseStrategy.generateLottoNumber()));
        }
        return lottos;
    }

    public Map<Rank, MatchingCount> checkLottoMatching(WinningLotto winningLotto, Lottos purchasedLottos) {
        Map<Rank, MatchingCount> matchingInfo = new HashMap<>();

        for(Rank rank : Rank.values()) {
            int matchingCount = getRankCount(winningLotto, purchasedLottos, rank);
            matchingInfo.put(rank, new MatchingCount(matchingCount));
        }

        return matchingInfo;
    }

    private int getRankCount(WinningLotto winningLotto, Lottos purchasedLottos, Rank rank) {
        int matchingCount = 0;

        for(Lotto lotto : purchasedLottos.getLottos()) {
            matchingCount = winningLotto.checkRank(lotto, rank) ? ++matchingCount : matchingCount;
        }

        return matchingCount;
    }

    public double calculateProfits(Map<Rank, MatchingCount> matcingInfo) {
        int totalPrize = INIT_COUNT;
        int lottoCount = INIT_COUNT;

        for(Rank rank : matcingInfo.keySet()) {
            totalPrize += rank.getWinningMoney() * matcingInfo.get(rank).getMatchingCount();
            lottoCount += matcingInfo.get(rank).getMatchingCount();
        }

        return Math.round((double)totalPrize / (lottoCount * LOTTO_PRICE) * 100)/ 100.0;
    }

}
