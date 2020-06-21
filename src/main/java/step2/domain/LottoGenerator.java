package step2.domain;

import static step2.view.ErrorMessages.INVALID_LOTTO_COUNT;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator extends Generating {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_SELECTION_COUNT = 6;

    public LottoGenerator(GenerableStrategy generableStrategy) {
        super(generableStrategy);
    }

    public LottoSheet generateLottos(int lottoCount) throws IllegalArgumentException{
        if (lottoCount < 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT);
        }
        List<UserLotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            lottos.add(new UserLotto(
                this.generate(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER, LOTTO_SELECTION_COUNT)));
        }
        return new LottoSheet(lottos);
    }
}
