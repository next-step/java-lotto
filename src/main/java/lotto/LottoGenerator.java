package lotto;

import java.math.BigDecimal;
import java.util.*;

public class LottoGenerator {

    public static Lotto generate() {
        List<Integer> list = new ArrayList<>();

        for (int i = Lotto.START_NUMBER; i <= Lotto.END_NUMBER; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return new Lotto(list.subList(0, Lotto.LOTTO_COUNT));
    }

    public static List<Lotto> generateLotto(BigDecimal amount) {
        LottoPurchase purchase = new LottoPurchase(amount);
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < purchase.size(); i++) {
            lotto.add(generate());
        }
        return lotto;
    }
}
