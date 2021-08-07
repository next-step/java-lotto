package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberTest {

    @DisplayName("1~45사이의 숫자를 입력")
    @SuppressWarnings("NonAsciiCharacters")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void LottoNumber_1_45_사이의_숫자(int input) {
        assertThat(new LottoNumber(input)).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("범위를 벗어난 숫자를 입력하면 예외 throw")
    @SuppressWarnings("NonAsciiCharacters")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void LottoNumber_범위를_벗어난_숫자(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(input);
        }).withMessageMatching("1부터 45 사이의 숫자를 등록해야 합니다.");
    }

    @DisplayName("입력한 숫자를 가져온다.")
    @SuppressWarnings("NonAsciiCharacters")
    @ParameterizedTest
    @ValueSource(ints = {5, 12, 21, 36})
    void getNumber_입력한_숫자(int input) {
        assertThat(new LottoNumber(input).getNumber()).isEqualTo(input);
    }

}
