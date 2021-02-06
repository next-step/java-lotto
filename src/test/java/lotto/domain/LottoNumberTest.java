package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {

    @DisplayName("잘못된 값 LottoNumber 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "2a", "0", "46"})
    public void constructorTest(String number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(number));
    }

    @DisplayName("LottoNumber equals 테스트 - 같은 원소값")
    @Test
    public void equalsTest() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
        assertThat(new LottoNumber(45)).isEqualTo(new LottoNumber(45));
    }


    @DisplayName("LottoNumber compare 테스트 - 크기비교")
    @Test
    public void compareTest() {
        assertThat(new LottoNumber(45)).isGreaterThan(new LottoNumber(44));
        assertThat(new LottoNumber(2)).isGreaterThan(new LottoNumber(1));
        assertThat(new LottoNumber(1)).isLessThan(new LottoNumber(2));
        assertThat(new LottoNumber(32)).isLessThanOrEqualTo(new LottoNumber(32));
    }

}