package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private LottoMachine() {
    }

    public static Lottos issueManualLottos(List<String> numbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String number : numbers) {
            lottos.add(new Lotto(new ManualLottoNumberGenerator(number).generate()));
        }
        return new Lottos(lottos);
    }

    public static Lottos issueAutoLottos(final int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(new AutoLottoNumberGenerator().generate()));
        }
        return new Lottos(lottos);
    }

}
