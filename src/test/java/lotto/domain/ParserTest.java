package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
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
        assertThat(numbers).containsExactly(LottoNumber.of(1)
                , LottoNumber.of(2)
                , LottoNumber.of(3)
                , LottoNumber.of(4)
                , LottoNumber.of(5)
                , LottoNumber.of(6));
    }
}