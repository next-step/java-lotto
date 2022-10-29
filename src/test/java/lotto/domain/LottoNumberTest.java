package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 1개 생성")
    void create() {
        LottoNumber number = LottoNumber.of("3");
        assertThat(number).isEqualTo(LottoNumber.of("3"));
    }

    @Test
    @DisplayName("로또 번호가 1에서 45 사이의 값이 아닌 경우")
    void numberOutOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of("46"));
    }

    @Test
    @DisplayName("로또 번호를 문자열 형식으로 반환")
    void getNumberByStringTest() {
        LottoNumber number = LottoNumber.of(7);
        String expected = "7";
        assertThat(number.getNumberByString())
                .isEqualTo(expected);
    }
}
