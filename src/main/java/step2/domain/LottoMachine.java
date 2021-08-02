package step2.domain;

import step2.util.LottoNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final Integer LOTTO_PRICE = 1000;

    private LottoMachine() {
    }

    public LottoNumber winOfLotto(List<Integer> winOfNumbers) {
        return new LottoNumber(winOfNumbers);
    }

    public static List<Lotto> createLottos(Wallet wallet) {
        final int lottoCount = wallet.currentMoney().money() / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.create(new LottoNumber(LottoNumberGenerator.create())));
        }

        return lottos;
    }
}
