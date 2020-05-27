package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void createLottoNumberTest_정상작동() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.getValue()).isEqualTo(1);
    }

    @Test
    void createLottoNumberTest_음수입력() {
        assertThatThrownBy(() -> new LottoNumber(-1))
                .hasMessageMatching("0 이하의 값을 입력했습니다.");
    }

    @Test
    void createLottoNumberTest_0입력() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .hasMessageMatching("0 이하의 값을 입력했습니다.");
    }
}
