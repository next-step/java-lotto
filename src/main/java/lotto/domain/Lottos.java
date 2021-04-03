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

    public static Lottos of(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    private static int getLottoPurchaseCount(int price) {
        return price / Lotto.PRICE_OF_A_PIECE_OF_LOTTO;
    }

    public Hit getWinnerStatistics(WinningNumber winningNumber, Hit hit) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumber);
            boolean isMatchBonus = lotto.isMatchBonus(winningNumber);
            hit.hittingLottoStatistics(matchCount, isMatchBonus);
        }
        return hit;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return this.lottos.size();
    }
}
