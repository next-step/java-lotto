package lotto;

import lotto.domain.*;
import lotto.domain.purchaseStrategy.PurchaseStrategy;

import java.util.*;

public class LottoShop {

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

    public Map<Rank, Integer> checkLottoMatching(WinningLotto winningLotto, Lottos purchasedLottos) {
        Map<Rank, Integer> matchingInfo = new HashMap<>();

        for(Rank rank : Rank.values()) {
            int matchingCount = getRankCount(winningLotto, purchasedLottos, rank);
            matchingInfo.put(rank, matchingCount);
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

    public double calculateProfits(Map<Rank, Integer> matcingInfo) {
        int totalPrize = INIT_COUNT;
        int lottoCount = INIT_COUNT;

        for(Rank rank : matcingInfo.keySet()) {
            totalPrize += rank.getWinningMoney() * matcingInfo.get(rank);
            lottoCount += matcingInfo.get(rank);
        }

        return Math.round((double)totalPrize / (lottoCount * LOTTO_PRICE) * 100)/ 100.0;
    }

}
