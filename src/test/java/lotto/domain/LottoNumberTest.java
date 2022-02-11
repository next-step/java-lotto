package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("정상적인 보너스 번호 문자열을 받아 객체를 생성하면 예외가 발생하지 않는다.")
    @Test
    void Given_정상_보너스_번호_When_객체_생성_Then_예외가_발생하지_않음() {
        // then
        assertDoesNotThrow(() -> new LottoNumber(7));
    }

    @DisplayName("1 ~ 45 범위의 숫자가 아니면 예외가 발생한다.")
    @Test
    void Given_로또_숫자_범위를_벗어난_수_When_객체_생성_Then_예외_발생() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(46));
    }
}
