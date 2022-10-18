package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottos {

    private final Lottos manualLottos;

    public ManualLottos(final Lottos manualLottos) {

        this.manualLottos = manualLottos;
    }

    public static ManualLottos from(final List<String> manualLottos) {

        return new ManualLottos(new Lottos(convertLottos(manualLottos)));
    }

    private static List<Lotto> convertLottos(final List<String> manualLottosInput) {

        return manualLottosInput.stream()
                .map(Lotto::from)
                .collect(Collectors.toList());
    }

    public Lottos getManualLottos() {

        return manualLottos;
    }
}
