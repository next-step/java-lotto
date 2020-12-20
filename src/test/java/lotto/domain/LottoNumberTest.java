package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 숫자 생성")
    void createLottoNumber() {
        LottoNumber number = new LottoNumber(3);
        assertThat(number).isEqualTo(new LottoNumber(3));
    }

    @Test
    @DisplayName("로또 숫자 생성 : IllegalArgumentException")
    void createLottoNumber_exception() {
        assertThatThrownBy(() -> LottoNumber.of("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }
}
