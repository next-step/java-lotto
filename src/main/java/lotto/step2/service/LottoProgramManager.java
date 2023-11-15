package lotto.step2.service;

import lotto.step2.domain.Lotto;
import lotto.step2.input.UserInput;
import lotto.step2.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoProgramManager {
    private LottoProgramManager() {
        throw new IllegalStateException("Service class");
    }

    public static List<Lotto> generateLottos(final UserInput input) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(input.getPassiveLottos());
        lottos.addAll(genarateAutoLottos(input.getAutoLottoCount()));

        return lottos;
    }

    private static List<Lotto> genarateAutoLottos(final int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generateLottoNumbers()));
        }

        return lottos;
    }
}
