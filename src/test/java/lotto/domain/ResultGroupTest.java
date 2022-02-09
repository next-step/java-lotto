package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultGroupTest {

    @Test
    void 결과의_갯수를_구할_수_있다() {
        //given
        ResultGroup resultGroup = new ResultGroup();
        //when
        resultGroup.updateResult(WinningResult.FIRST);
        //then
        assertThat(resultGroup.howManyHave(WinningResult.FIRST)).isEqualTo(1);
    }
}
