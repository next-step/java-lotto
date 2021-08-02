package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final Integer LOTTO_PRICE = 1000;

    private LottoMachine() {
    }

    public static List<Lotto> createLottos(Integer givenMoney) {

        final int lottoCount = givenMoney / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.create(LottoNumberGenerator.create()));
        }

        return lottos;
    }
}
