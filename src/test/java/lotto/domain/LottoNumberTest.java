package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @DisplayName("1~45 사이의 로또번호 생성")
    @ParameterizedTest
    @ValueSource(ints = {1,15,30,45})
    void lottoNumber_로또번호_생성(int input) {
        assertThat(new LottoNumber(input)).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("번호가 1~45 사이가 아닐때 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 46})
    void lottoNumber_범위를_벗어난_번호(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(input);
        }).withMessageMatching("1부터 45 사이의 숫자를 등록해야 합니다.");
    }

    @DisplayName("입력한 번호를 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 7, 15, 37})
    void getLottoNumber_입력한_번호를_반환(int input) {
        assertThat(new LottoNumber(input).getLottoNumber()).isEqualTo(input);
    }

}
