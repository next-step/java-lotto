package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;

public class RandomLottoGenerator implements LottoGenerator {
    private final long automaticIssueQuantity;

    public RandomLottoGenerator(long automaticIssueQuantity) {
        this.automaticIssueQuantity = automaticIssueQuantity;
    }

    @Override
    public Lottos generate() {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < automaticIssueQuantity; i++) {
            lottos.add(getRandomLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto getRandomLotto() {
        return LottoNumber.getRandomLotto(LOTTO_NUMBER_COUNT);
    }
}
