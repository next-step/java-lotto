package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMachine {
    public static final long LOTTO_UNIT_PRICE = 1000;

    public static LottoList purchase(final long purchaseAmount) {
        if (purchaseAmount < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(LOTTO_UNIT_PRICE + " OR MORE");
        }

        return new LottoList((int) (purchaseAmount / LOTTO_UNIT_PRICE));
    }

    public static Map<Prize, LottoList> getWinningResult(final LottoList lottos, final Lotto winningLotto) {
        Map<Prize, LottoList> lottoResult = new HashMap<>();

        for (Prize prize : Prize.values()) {
            LottoList winningLottos = lottos.find(prize, winningLotto);

            lottoResult.put(prize, winningLottos);
        }

        return lottoResult;
    }

    public static double getEarningsRate(final Map<Prize, LottoList> lottoResult, final long purchaseAmount) {
        long totalPrizeMoney = 0;

        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize).size() * prize.getMoney();
        }

        return totalPrizeMoney / (double) purchaseAmount;
    }
}
