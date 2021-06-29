package lottoAuto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @DisplayName("당첨 번호 문자열을 , 기준으로 나눌 수 있다.")
    @Test
    public void splitWinningNumberTest() {
        StringUtil stringUtil = new StringUtil();

        Lotto lotto = stringUtil.makeLotto("1,2,3,4,5,6");

        assertThat(6).isEqualTo(lotto.getLottoNumbers().size());
    }
}
