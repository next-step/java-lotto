package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultStatusTest {

    @Test
    public void 당첨번호에_따른_상태_확인_당첨X_0개() {
        assertThat(LottoResultStatus.findByMatchCount(0)).isEqualTo(LottoResultStatus.NONE);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨X_1개() {
        assertThat(LottoResultStatus.findByMatchCount(1)).isEqualTo(LottoResultStatus.NONE);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨X_2개() {
        assertThat(LottoResultStatus.findByMatchCount(2)).isEqualTo(LottoResultStatus.NONE);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨3() {
        assertThat(LottoResultStatus.findByMatchCount(3)).isEqualTo(LottoResultStatus.WINNING_NUM_3);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨4() {
        assertThat(LottoResultStatus.findByMatchCount(4)).isEqualTo(LottoResultStatus.WINNING_NUM_4);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨5() {
        assertThat(LottoResultStatus.findByMatchCount(5)).isEqualTo(LottoResultStatus.WINNING_NUM_5);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨6() {
        assertThat(LottoResultStatus.findByMatchCount(6)).isEqualTo(LottoResultStatus.WINNING_NUM_6);
    }
}
