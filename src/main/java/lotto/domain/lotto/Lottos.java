package lotto.domain.lotto;

import lotto.constants.LottoConstants;
import lotto.domain.lotto.strategy.GenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos of(int purchasePrice, GenerateStrategy strategy) {
        int lottoCount = lottoCount(purchasePrice);

        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(Lotto.of(strategy));
        }

        return new Lottos(lottoList);
    }

    private static int lottoCount(int purchasePrice) {
        int lottoCount = purchasePrice / LottoConstants.PRICE_PER_TICKET;
        validation(lottoCount);
        return lottoCount;
    }

    private static void validation(int lottoCount) {
        if (lottoCount == 0) {
            throw new IllegalArgumentException(LottoConstants.PURCHASE_ERROR_MESSAGE);
        }
    }

    public int size() {
        return lottos.size();
    }
}
