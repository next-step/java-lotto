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

    public static Lottos generate(BigDecimal amount, Lottos manualLotto) {
        LottoPurchase purchase = new LottoPurchase(amount);
        List<Lotto> lotto = new ArrayList<>(manualLotto.lottos()); // 수동 로또 추가

        int autoCount = purchase.size() - manualLotto.size(); // 자동 로또 개수 계산
        for (int i = 0; i < autoCount; i++) {
            lotto.add(generate()); // 자동 로또 생성
        }
        return new Lottos(lotto);
    }
}
