package lotto.domain;

import lotto.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;
    private final int availablePurchaseLottoCount;

    public LottoStore(int purchasePrice) {
        this.availablePurchaseLottoCount = purchasePrice / LOTTO_PRICE;
    }

    public Lottos sellLotto() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < availablePurchaseLottoCount; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    private LottoMarkingNumbers generateRandomLottoNumbers() {
        List<LottoNumber> lottoMarkingNumbers = RandomNumberGenerator.generate().stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        return new LottoMarkingNumbers(lottoMarkingNumbers);
    }
}
