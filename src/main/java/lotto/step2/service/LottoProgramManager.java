package lotto.step2.service;

import lotto.step2.domain.Lotto;
import lotto.step2.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoProgramManager {
    private LottoProgramManager() {
        throw new IllegalStateException("Service class");
    }

    public static int calculateNumberOfLottos(final int purchaseAmount, final int lottoPrice) {
        return purchaseAmount / lottoPrice;
    }

    public static List<Lotto> generateLottos(final int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generateLottoNumbers()));
        }

        return lottos;
    }
}
