package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 확인")
    @Test
    void createLottoNumber() {
        int actual = 2;
        LottoNumber number = new LottoNumber(actual);

        assertThat(number).isNotNull();
    }

    @DisplayName("로또 번호는 0에서 45사이의 값만 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void createLottoNumberRange(Integer actual) {
        assertThatThrownBy(() -> new LottoNumber(actual))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 번호 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "1:1:0", "2:1:1"}, delimiter = ':')
    void compareLottoNumber(String x, String y, int compareValue) {
        LottoNumber numberX = new LottoNumber(x);
        LottoNumber numberY = new LottoNumber(y);

        assertThat(numberX.compareTo(numberY)).isEqualTo(compareValue);
    }

    @DisplayName("로또 번호 동등성 테스트")
    @Test
    void equalLottoNumber() {
        LottoNumber x = new LottoNumber(1);
        LottoNumber y = new LottoNumber(1);

        assertThat(x.equals(y)).isTrue();
    }
}
