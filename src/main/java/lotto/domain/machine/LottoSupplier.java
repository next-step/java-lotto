package lotto.domain.machine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoSupplier {

    public static List<Lotto> makeManualLotto(List<List<Integer>> lottoNumbers) {
        final List<Lotto> manualLottos = new ArrayList<>();
        lottoNumbers.stream()
            .forEach(lottoNumber -> manualLottos.add(Lotto.from(lottoNumber)));
        return manualLottos;
    }
}
