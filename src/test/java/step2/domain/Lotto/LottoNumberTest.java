package step2.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("LottoNumber 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 1;

        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(inputValue);

        // then
        assertThat(lottoNumber).isNotNull();
    }
}