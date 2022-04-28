package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
    private LottoMarket() {
        throw new AssertionError();
    }

    public static List<Lottos> buyLottos(int money, LottoGenerator lottoGenerator) {
        validate(money);
        return getLottos(money, lottoGenerator);
    }

    private static void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액은 음수일 수 없습니다. money: " + money);
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액은 천원 단위여야 합니다. money: " + money);
        }
    }

    private static List<Lottos> getLottos(int money, LottoGenerator lottoGenerator) {
        int count = getCount(money);

        List<Lottos> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.get());
        }

        return lottos;
    }

    private static int getCount(int money) {
        return money / 1000;
    }
}
