package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 100})
    void 숫자범위(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(number))
            .withMessageMatching("숫자 범위를 벗어났습니다 : " + number);
    }

    @Test
    void 숫자생성() {
        assertAll(
            () -> {
                for (int i = 1; i <= 45; i++) {
                    assertThat(new LottoNumber(i)).isEqualTo(new LottoNumber(i));
                }}
        );
    }

}
