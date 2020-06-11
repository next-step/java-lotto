package lotto.domain.generator;

import lotto.domain.data.Lotto;
import lotto.domain.data.ManualLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator {

    public static List<Lotto> generate(List<ManualLotto> manualLottos) {
        final List<Lotto> lottos = new ArrayList<>();

        if(manualLottos == null) {
            return lottos;
        }

        List<ManualLotto> targetManualLottos = manualLottos.stream()
                .filter(manualLotto -> !manualLotto.isEmpty())
                .collect(Collectors.toList());
        for (ManualLotto manualLotto : targetManualLottos) {
            lottos.add(Lotto.of(manualLotto.getNumbers()));
        }

        return lottos;
    }

}
