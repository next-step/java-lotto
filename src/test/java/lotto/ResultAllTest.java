package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultAllTest {

    @Test
    public void updateResult_3등로또당첨_HASHMAP_추가_확인() {
        ResultAll resultAll = new ResultAll();
        SameNumberCountInALotto sameNumberCountInALotto = new SameNumberCountInALotto(3,false);

        resultAll.updateResult(sameNumberCountInALotto);
        assertThat(resultAll.result().get(ResultScoreEnum.FIFTH)).isEqualTo(1);
    }

    @Test
    public void yield_수익률확인() {
        ResultAll resultAll = new ResultAll();
        SameNumberCountInALotto sameNumberCountInALotto = new SameNumberCountInALotto(3,false);

        resultAll.updateResult(sameNumberCountInALotto);
        assertThat(resultAll.yield(5000)).isEqualTo(1);
    }
}
