package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    public static List<Object> buy(int buyCount) {
        if (buyCount < 1) {
            throw new IllegalArgumentException("1개 이상 구매 가능");
        }
        List<Object> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(new Object());
        }
        return lottos;
    }

    public static List<Object> match(List<Object> lottos, String winningLottoNumbers) {
        // TODO: compare
        return null;
    }

}
