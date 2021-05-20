package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 생성기.
 */
public class LottoGenerator {
    private final int count;

    public LottoGenerator(final Money money) {
        this.count = money.getLottoCount();
    }

    /**
     * 구매한 로또를 가져온다.
     */
    public List<Lotto> getPurchasedLottos() {
        final List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.addAll(generateLottos());
        return purchasedLottos;
    }

    private List<Lotto> generateLottos() {
        final List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<LottoNumber> lottoNumbers = LottoNumberGenerator.getLottoNumbers();
            generatedLottos.add(new Lotto(lottoNumbers));
        }
        return generatedLottos;
    }
}
