package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;

import java.util.Collections;
import java.util.List;

public class LottoWinningResult {
    private List<LottoAward> awardResult;

    public LottoWinningResult(List<LottoAward> awardResult) {
        this.awardResult = awardResult;
    }

    public List<LottoAward> getAwardResult() {
        return Collections.unmodifiableList(awardResult);
    }
}
