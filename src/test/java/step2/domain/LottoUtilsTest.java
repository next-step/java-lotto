package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 유틸")
public class LottoUtilsTest {

    @Test
    public void splitWinningNumberLineAndReturnLottoNumbers() {
        assertThat(LottoUtils.splitWinningNumberLineAndReturnLottoNumbers("1, 2, 3")).hasSize(3);
        assertThat(LottoUtils.splitWinningNumberLineAndReturnLottoNumbers("1, 2, 3")).contains(1, 2, 3);
    }

}
