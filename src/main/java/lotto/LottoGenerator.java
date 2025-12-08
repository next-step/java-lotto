package lotto;

import java.math.BigDecimal;
import java.util.*;

public class LottoGenerator {

    public static Lotto generate() {
        List<Integer> list = new ArrayList<>();

        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        return new Lotto(list.subList(0, Lotto.LOTTO_COUNT));
    }

    public static Lottos generateLotto(BigDecimal amount) {
        LottoPurchase purchase = new LottoPurchase(amount);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchase.size(); i++) {
            lottos.add(generate());
        }
        return new Lottos(lottos);
    }
}
