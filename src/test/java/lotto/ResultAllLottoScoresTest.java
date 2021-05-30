package lotto;

import lotto.domain.ResultAllLottoScores;
import lotto.domain.ResultScoreEnum;
import lotto.domain.MatchStatusOfALotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultAllLottoScoresTest {

    @Test
    public void updateResult_3등로또당첨_HASHMAP_추가_확인() {
        ResultAllLottoScores resultAllLottoScores = new ResultAllLottoScores();
        MatchStatusOfALotto matchStatusOfALotto = new MatchStatusOfALotto(3,false);

        resultAllLottoScores.updateResult(matchStatusOfALotto);
        assertThat(resultAllLottoScores.result().get(ResultScoreEnum.FIFTH)).isEqualTo(1);
    }

    @Test
    public void yield_수익률확인() {
        ResultAllLottoScores resultAllLottoScores = new ResultAllLottoScores();
        MatchStatusOfALotto matchStatusOfALotto = new MatchStatusOfALotto(3,false);

        resultAllLottoScores.updateResult(matchStatusOfALotto);
        assertThat(resultAllLottoScores.yield(5000)).isEqualTo(1);
    }
}
