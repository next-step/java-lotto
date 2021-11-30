package lotto.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("생성 테스트")
    void createTest() {
        LottoNumber lottoNumber = new LottoNumber(3);

        assertThat(lottoNumber.getNumber()).isEqualTo(3);

    }

    @ParameterizedTest
    @DisplayName("1~45까지의 숫자 검증")
    @ValueSource(ints = {0,46})
    void exceptionTest(int number) {

        assertThatThrownBy(() ->
                new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
