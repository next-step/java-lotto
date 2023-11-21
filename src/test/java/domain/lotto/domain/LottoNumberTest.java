package domain.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void create_lotto_number_success() {
        int number = 1;
        LottoNumber lottoNumber = LottoNumber.from(number);

        assertThat(lottoNumber).isNotNull();
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("1~45 이외의 수로 로또 번호 생성 시 IllegalArgumentException 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_lotto_number_fail(int input) {
        assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }

    @DisplayName("Random 객체를 이용하여 로또 번호 생성 테스트 (실패하지 않아야 함)")
    @Test
    void create_number_with_random() {
        final Random random = new Random();

        assertThat(LottoNumber.from(random)).isNotNull();
    }

}
