package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultStatusTest {

    @Test
    public void 당첨번호에_따른_상태_확인_당첨X() {
        assertThat(LottoResultStatus.of(2)).isEqualTo(LottoResultStatus.NONE);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨3() {
        assertThat(LottoResultStatus.of(3)).isEqualTo(LottoResultStatus.WINNING_NUM_3);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨4() {
        assertThat(LottoResultStatus.of(4)).isEqualTo(LottoResultStatus.WINNING_NUM_4);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨5() {
        assertThat(LottoResultStatus.of(5)).isEqualTo(LottoResultStatus.WINNING_NUM_5);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨6() {
        assertThat(LottoResultStatus.of(6)).isEqualTo(LottoResultStatus.WINNING_NUM_6);
    }
}
