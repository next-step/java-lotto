package lotto;

import lotto.domain.MatchStatusOfALotto_ref;
import lotto.domain.ResultAllLottoScores_ref;
import lotto.domain.ResultScoreEnum_ref;
import lotto.domain.MatchStatusOfALotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultAllLottoScoresRefTest {

    @Test
    public void updateResult_3등로또당첨_HASHMAP_추가_확인() {
        ResultAllLottoScores_ref resultAllLottoScoresRef = new ResultAllLottoScores_ref();
        MatchStatusOfALotto_ref matchStatusOfALotto = new MatchStatusOfALotto_ref(3,false);

        resultAllLottoScoresRef.updateResult(matchStatusOfALotto);
        assertThat(resultAllLottoScoresRef.result().get(ResultScoreEnum_ref.FIFTH)).isEqualTo(1);
    }

    @Test
    public void yield_수익률확인() {
        ResultAllLottoScores_ref resultAllLottoScoresRef = new ResultAllLottoScores_ref();
        MatchStatusOfALotto_ref matchStatusOfALotto = new MatchStatusOfALotto_ref(3,false);

        resultAllLottoScoresRef.updateResult(matchStatusOfALotto);
        assertThat(resultAllLottoScoresRef.yield(5000)).isEqualTo(1);
    }
}
