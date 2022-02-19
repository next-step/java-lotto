package lotto.domain.machine;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class LottoSupplier {

    public static List<Lotto> makeManualLotto(List<List<LottoNumber>> lottos) {
        return lottos.stream()
            .map(Lotto::new)
            .collect(Collectors.toList());
    }
}
