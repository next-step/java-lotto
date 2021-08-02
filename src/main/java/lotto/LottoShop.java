package lotto;

import lotto.domain.*;
import lotto.domain.purchaseStrategy.PurchaseStrategy;

import java.util.*;

public class LottoShop {

    private static final String BELOW_MIN_AMOUNT_ERROR_MESSAGE = "최소 1000원 이상 지불하셔야 합니다.";
    private static final int LOTTO_PRICE = 1000;

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
        for(int i = 0; i < amount/LOTTO_PRICE; i++) {
            lottos.add(new Lotto(purchaseStrategy.generateLottoNumber()));
        }
        return lottos;
    }

    //// 당첨통계

    // 일치여부
    public Map<Rank, Integer> checkLottoMatching(WinningLotto winningLotto, Lottos purchasedLottos) {
        Map<Rank, Integer> matchingInfo = new HashMap<>();

        for(Rank rank : Rank.values()) {
            int matchingCount = winningLotto.getMatchingLottoNumberCount(rank, purchasedLottos);
            matchingInfo.put(rank, matchingCount);
        }

        return matchingInfo;
    }

    // 수익률계산



}
