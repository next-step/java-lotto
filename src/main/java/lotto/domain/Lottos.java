package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(final PurchasePrice purchasePrice) {
        for (int i = 0; i < purchasePrice.calculatePurchaseCount(); i++) {
            lottos.add(generate());
        }
    }

    private Lotto generate() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != Lotto.LOTTO_SIZE) {
            lottoNumbers.add(LottoNumber.from());
        }
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
