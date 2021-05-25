package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultAllTest {

    @Test
    public void updateResult_3등확인() {
        ResultAll resultAll = new ResultAll();
        SameNumberCountInALotto sameNumberCountInALotto = new SameNumberCountInALotto();
        for(int i=0; i<3; i++)
            sameNumberCountInALotto.updateCount(SameNumberStateEnum.SAME_MAIN_NUMBER);

        resultAll.updateResult(sameNumberCountInALotto);
        assertThat(resultAll.getResult().get(ResultScoreEnum.FIFTH)).isEqualTo(1);
    }

    @Test
    public void yield_수익률확인() {
        ResultAll resultAll = new ResultAll();
        SameNumberCountInALotto sameNumberCountInALotto = new SameNumberCountInALotto();
        for(int i=0; i<3; i++)
            sameNumberCountInALotto.updateCount(SameNumberStateEnum.SAME_MAIN_NUMBER);

        resultAll.updateResult(sameNumberCountInALotto);
        assertThat(resultAll.yield(5000)).isEqualTo(1);
    }
}
