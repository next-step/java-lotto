package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos newRandomLottos(int price, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> list = new ArrayList<>();
        int count = getLottoPurchaseCount(price);

        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.of(lottoNumberGenerator);
            list.add(lotto);
        }
        return new Lottos(list);
    }

    public static Lottos newManualLottos(List<String> lottoList) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (String lotto : lottoList) {
            Lotto manualLotto = Lotto.of(new FixedGenerator(lotto));
            manualLottos.add(manualLotto);
        }
        return new Lottos(manualLottos);
    }

    private static int getLottoPurchaseCount(int price) {
        return price / LottoConstant.PRICE_OF_A_PIECE_OF_LOTTO;
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
