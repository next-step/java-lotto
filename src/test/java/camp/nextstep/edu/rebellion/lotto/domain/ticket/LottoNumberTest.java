package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("생성된 로또 번호가 올바른지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void rangeTest(int input) {
        // when & then
        assertDoesNotThrow(() -> new LottoNumber(input));
    }

    @DisplayName("잘못된 번호 입력시 예외 발생 (1미만) ")
    @Test
    public void rangeMinTest() {
        // when & then
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 잘못되었습니다 0");
    }

    @DisplayName("잘못된 번호 입력시 예외 발생 (45 초과) ")
    @Test
    public void rangeMaxTest() {
        // when & then
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 잘못되었습니다 46");
    }

    @DisplayName("입력된 번호와 일치 하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "5:false"
    }, delimiter = ':')
    public void equalTest(int input, boolean expected) {
        // given
        LottoNumber number = new LottoNumber(1);

        // when & then
        assertThat(number.equals(new LottoNumber(input)))
                .isEqualTo(expected);
    }
}
