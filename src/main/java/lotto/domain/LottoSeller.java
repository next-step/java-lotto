package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private final NumberGenerator numberGenerator;

    public LottoSeller(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> sellLottos(int price) {
        assertValidCountRange(price);
        int count = price / Lotto.PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(new LottoNumbers(numberGenerator)));
        }

        return lottos;
    }

    private void assertValidCountRange(int price) {
        String message = "[셀러] 올바른 가격을 입력해주세요.";
        if (price < 0 || price % Lotto.PRICE > 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
