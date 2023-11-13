package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final int PRICE_PER_TICKET = 1000;
    public static final String PURCHASE_ERROR_MESSAGE = String.format("로또를 구매할 금액이 부족합니다. 로또 한장의 가격은 %s원 입니다.", PRICE_PER_TICKET);

    List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos from(int purchasePrice) {
        int lottoCount = lottoCount(purchasePrice);

        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(Lotto.newLotto());
        }

        return new Lottos(lottoList);
    }

    private static int lottoCount(int purchasePrice) {
        int lottoCount = purchasePrice / PRICE_PER_TICKET;
        validation(lottoCount);
        return lottoCount;
    }

    private static void validation(int lottoCount) {
        if (lottoCount == 0) {
            throw new IllegalArgumentException(PURCHASE_ERROR_MESSAGE);
        }
    }

    public int size() {
        return lottos.size();
    }
}
