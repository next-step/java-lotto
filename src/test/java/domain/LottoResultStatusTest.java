package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultStatusTest {

    @Test
    public void 당첨번호에_따른_상태_확인_당첨X() {
        assertThat(LottoResultStatus.findByMatchCount(0, false)).isEqualTo(LottoResultStatus.NONE);
        assertThat(LottoResultStatus.findByMatchCount(1, false)).isEqualTo(LottoResultStatus.NONE);
        assertThat(LottoResultStatus.findByMatchCount(2, false)).isEqualTo(LottoResultStatus.NONE);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨3() {
        assertThat(LottoResultStatus.findByMatchCount(3, false)).isEqualTo(LottoResultStatus.WINNING_NUM_3);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨4() {
        assertThat(LottoResultStatus.findByMatchCount(4, false)).isEqualTo(LottoResultStatus.WINNING_NUM_4);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨5() {
        assertThat(LottoResultStatus.findByMatchCount(5, false)).isEqualTo(LottoResultStatus.WINNING_NUM_5);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨5_보너스번호_당첨() {
        assertThat(LottoResultStatus.findByMatchCount(5, true)).isEqualTo(LottoResultStatus.WINNING_NUM_5_BONUS);
    }


    @Test
    public void 당첨번호에_따른_상태_확인_당첨6() {
        assertThat(LottoResultStatus.findByMatchCount(6, false)).isEqualTo(LottoResultStatus.WINNING_NUM_6);
    }
}
