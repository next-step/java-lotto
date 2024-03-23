package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE = 1_000;

    private final LottoFactory lottoFactory;

    public LottoGame(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public double calculateReturnOfRate(Lotto winnerLotto, List<Lotto> lottos) {
        int returnOfRate = 0;
        int purchaseAmount = calculatePurchaseAmount(lottos);
        for (Lotto lotto : lottos) {
            returnOfRate += winnerLotto.getPrize(lotto);
        }
        return Math.floor(((double) returnOfRate / purchaseAmount) * 100) / 100;
    }

    public List<Rank> checkRanks(Lotto winnerLotto, List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(winnerLotto.getRank(lotto));
        }
        return ranks;
    }

    public List<Lotto> createLottos(int money) {
        return this.lottoFactory.createLottos(money, PRICE);
    }

    public Lotto createLotto(List<Integer> numbers) {
        return this.lottoFactory.createLotto(numbers);
    }

    private int calculatePurchaseAmount(List<Lotto> lottos) {
        return lottos.size() * PRICE;
    }
}
