package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int price) {
        return of(price, new RandomGenerator());
    }

    public static Lottos of(int price, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> list = new ArrayList<>();
        int count = getLottoPurchaseCount(price);

        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.of(lottoNumberGenerator);
            list.add(lotto);
        }
        return new Lottos(list);
    }

    public Hit getWinnerStatistics(WinningNumber winningNumber) {
        Hit hit = new Hit();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumber);
            hit.hittingLottoStatistics(matchCount);
        }
        return hit;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static int getLottoPurchaseCount(int price) {
        return price / Lotto.PRICE_OF_A_PIECE_OF_LOTTO;
    }

    public int getSize() {
        return this.lottos.size();
    }
}
