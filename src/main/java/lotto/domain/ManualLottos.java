package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottos {

    private final Lottos manualLottos;

    public ManualLottos(final Lottos manualLottos) {

        this.manualLottos = manualLottos;
    }

    public static ManualLottos of(final int countOfLottos, final List<String> manualLottos) {

        validate(countOfLottos, manualLottos.size());
        return new ManualLottos(new Lottos(convertLottos(manualLottos)));
    }

    private static void validate(final int countOfTotalLotto, final int countOfManualLotto) {

        if (countOfTotalLotto < countOfManualLotto) {
            throw new IllegalArgumentException("지불한 금액보다 수동으로 구입하려는 로또가 더 많습니다.");
        }
        if (countOfTotalLotto != countOfManualLotto) {
            throw new IllegalArgumentException("수동 구매한 로또수와 수동 로또 입력값이 맞지 않습니다.");
        }
    }

    private static List<Lotto> convertLottos(final List<String> manualLottosInput) {

        return manualLottosInput.stream()
                .map(LottoFactory::from)
                .collect(Collectors.toList());
    }

    public Lottos getManualLottos() {

        return manualLottos;
    }

    public int count() {

        return this.manualLottos.getLottos()
                .size();
    }
}
