package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static int buyLotto(int money) {
        validateMoney(money);

        return money / 1000;
    }

    private static void validateMoney(int money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000 단위로 입력해 주시기 바랍니다.");
        }
    }

    public static List<Lotto> pickUpLottos(int lotOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lotOfLotto; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
