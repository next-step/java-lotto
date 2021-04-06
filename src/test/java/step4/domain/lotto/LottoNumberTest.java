package step4.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.LottoNumberOutOfRangeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("LottoNumber 인스턴스에 부적절한 값 주입시 예외처리 여부 테스트")
    @ParameterizedTest(name = "{index}번 째 반복, 주입값 : {0}")
    @ValueSource(ints = {-1, 0, 46})
    void 검증(int inputValue) {

        // when and then
        assertThatThrownBy(()-> LottoNumber.valueOf(inputValue))
                .isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또의 범위를 벗어난 숫자가 입력되었습니다.");
    }
}