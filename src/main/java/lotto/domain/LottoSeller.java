package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private final NumberGenerator numberGenerator;

    public LottoSeller(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> sellLottos(int count) {
        assertValidCountRange(count);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(new LottoNumbers(numberGenerator)));
        }

        return lottos;
    }

    private void assertValidCountRange(int count) {
        String message = "[셀러] 올바른 개수를 입력해주세요.";
        if (count < 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
