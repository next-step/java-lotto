package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static final int PRICE = 1000;

    public static List<Lotto> generateLottos(int totalPrice) {
        validationCheck(totalPrice);
        int lottoCount = totalPrice / PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private static void validationCheck(int totalPrice) {
        if (totalPrice < 0) {
            throw new IllegalArgumentException("구입금액은 음수를 입력할 수 없습니다.");
        }
    }
}
