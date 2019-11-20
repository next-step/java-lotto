package lotto.domain;

import lotto.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-21 00:04
 */
public class Lottos {

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(LottoPurchase lottoPurchase, List<String> manualLottoNumbers) {
        issue(lottoPurchase, manualLottoNumbers);
    }

    private void issue(LottoPurchase lottoPurchase, List<String> manualLottoNumbers) {
        for (String manualLottoNumber : manualLottoNumbers) {
            lottos.add(Lotto.of(Util.stringToList(manualLottoNumber)));
        }

        for (int i = 0; i < lottoPurchase.getAutoLottoCount(); i++) {
            lottos.add(Lotto.of(LOTTO_GENERATOR.generate()));
        }
    }

    public List<Lotto> getLottoNumbers() {
        return Collections.unmodifiableList(this.lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
