package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    public static List<Object> buy(int buyCount) {
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
