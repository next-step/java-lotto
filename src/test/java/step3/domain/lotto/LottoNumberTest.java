package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.LottoNumberOutOfRangeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("LottoNumber 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int value = 1;

        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(value);

        // then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("LottoNumber 인스턴스에 0이하의 수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_0이하의수() {
        // given
        int fistValue = 0;
        int secondValue = -1;

        // when
        assertThatThrownBy(() -> {
            LottoNumber.valueOf(fistValue);
            LottoNumber.valueOf(secondValue);
        }).isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또의 범위를 벗아난 숫자가 입력되었습니다.");

    }

    @DisplayName("LottoNumber 인스턴스에 46이상의 수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_46이상의수() {
        // given
        int value = 46;

        // when
        assertThatThrownBy(() -> LottoNumber.valueOf(value))
                .isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또의 범위를 벗아난 숫자가 입력되었습니다.");

    }

}