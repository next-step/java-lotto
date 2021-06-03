package lotto.domain;

import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 번호를 수동으로 생성
 */
public final class LottoNumberManualGenerator implements LottoNumberGenerator {
    private final List<String> manualLottos;

    public LottoNumberManualGenerator(final List<String> manualLottos) {
        this.manualLottos = manualLottos;
    }

    @Override
    public List<Lotto> drawLots(final int lottoCount) {
        final List<Lotto> lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Splitter.split(manualLottos.get(i))));
        }
        return lottos;
    }
}
