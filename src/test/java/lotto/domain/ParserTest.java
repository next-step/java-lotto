package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
    @DisplayName("문자열이 숫자포맷이 아니라면 IllegalArgumentException 예외를 발생")
    @Test
    void 숫자포맷_아닐경우_예외발생() {
        assertThatThrownBy(() -> Parser.numberParsing("12000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("문자열을 숫자로 파싱한 결과를 리턴.")
    @Test
    void 숫자포맷_파싱() {
        assertThat(Parser.numberParsing("14000")).isEqualTo(14_000);
    }

    @DisplayName("음수 전달 시 예외 발생")
    @Test
    void 음수_전달() {
        assertThatThrownBy(() -> Parser.numberParsing("-14000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("파싱된 숫자 리스트 사이즈가 6이 아닐경우 예외 발생")
    @Test
    void 숫자_리스트_파싱_예외발생() {
        assertThatThrownBy(() -> Parser.numbersParsing("1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("파싱된 숫자 리스트 사이즈가 6일때 LottoNumber 리스트 리턴")
    @Test
    void 숫자_리스트_파싱() {
        List<LottoNumber> numbers = Parser.numbersParsing("1,2,3,4,5,6");
        assertThat(numbers).containsExactly(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }
}