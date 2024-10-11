package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("로또 숫자는 1이상 45이하의 범위를 가진다")
    @Test
    void numberRange(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(0))
                .withMessage("로또 숫자는 1이상 45이하 범위 이내에서 입력하세요");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber("46"))
                .withMessage("로또 숫자는 1이상 45이하 범위 이내에서 입력하세요");
    }


}