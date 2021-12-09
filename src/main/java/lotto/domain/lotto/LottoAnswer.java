package lotto.domain.lotto;

import java.util.List;

public class LottoAnswer extends Lotto {

    public LottoAnswer(List<Integer> answer) {
        super(answer);
    }

    @Override
    public int matchCount(Lotto lotto) {
        return super.matchCount(lotto);
    }
}
