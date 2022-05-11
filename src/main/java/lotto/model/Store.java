package lotto.model;

import lotto.util.AwardNumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class Store {
    private static final long PRODUCT_PRICE = 1_000L;

    private final int manualLottoCount;

    public Store(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
    }

    public Lottos auto(long money) {
        long count = (money / PRODUCT_PRICE) - manualLottoCount;
        List<Lotto> lotteryTickets = new ArrayList<>();
        while (count-- != 0) {
            lotteryTickets.add(deliverLotto());
        }
        return new Lottos(lotteryTickets, lotteryTickets.size());
    }

    private Lotto deliverLotto() {
        return LottoFactory.apply();
    }

    public Lottos manualLottos(List<Set<Integer>> inputLottos) {
        return new Lottos(AwardNumberUtil.convertLotto(inputLottos), manualLottoCount);
    }

}