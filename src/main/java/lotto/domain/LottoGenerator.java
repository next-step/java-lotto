package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int PRICE_MONEY_UNIT = 1000;

    public LottoGenerator() {
    }

    public List<Lotto> purchaseLotto(final int money) {
        int purchaseCount = money / PRICE_MONEY_UNIT;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != LOTTO_SIZE) {
            lottoNumbers.add(LottoNumber.generateLottoNumber());
        }
        return new Lotto(new ArrayList<>(lottoNumbers));
    }
}
