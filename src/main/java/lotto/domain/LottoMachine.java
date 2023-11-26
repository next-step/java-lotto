package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {


    private LottoMachine() {
    }

    public static List<Lotto> issueManualLottos(List<String> numbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String number : numbers) {
            lottos.add(new Lotto(new ManualLottoNumberGenerator(number).generate()));
        }
        return lottos;
    }

    public static List<Lotto> issueAutoLottos(final int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(new AutoLottoNumberGenerator().generate()));
        }
        return lottos;
    }

    public static List<Lotto> addAllLottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);
        return lottos;
    }
}
