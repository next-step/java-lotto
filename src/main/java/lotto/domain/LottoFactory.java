package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static final int PRICE = 1000;

    public static List<Lotto> createLottos(int totalPrice, NumberGeneratorStrategy strategy) {
        validationCheck(totalPrice);

        int lottoCount = totalPrice / PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(strategy.generateNumbers()));
        }
        return lottos;
    }

    public static List<Lotto> createLottos(int totalPrice) {
        return createLottos(totalPrice, new RandomNumberGeneratorStrategy());
    }

    private static void validationCheck(int totalPrice) {
        if (totalPrice < 1000) {
            throw new IllegalArgumentException("구입금액은 최소 1000원 이상입니다.");
        }
    }
}
