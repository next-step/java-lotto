package lotto.domain;

import java.security.InvalidParameterException;

public class LottoStore {
    private static final int PRICE = 1000;
    public static Lottos buyLottos(int money) {
        if (money < PRICE) {
            throw new InvalidParameterException("1000 원 이하면 게임이 불가능합니다.");
        }
        return new Lottos(money/PRICE);
    }
}
