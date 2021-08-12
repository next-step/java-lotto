package lotto.domain;

import lotto.exception.LottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTests {

    @DisplayName("로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createLottoNumberTest(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber == LottoNumber.of(number)).isTrue();
        assertThat(LottoNumber.of(number)).isEqualTo(LottoNumber.of(number));
    }

    @DisplayName("로또 번호 생성시 로또 번호 생성 범위 넘었을 때 exception 테스트")
    @Test
    void createLottoNumberExceptionTest() {

        assertThatExceptionOfType(LottoNumberRangeException.class)
                .isThrownBy(() -> {
                    LottoNumber.of(46);
                }).withMessageMatching("로또 숫자는 1 ~ 45 사이의 숫자만 가능 합니다.");
    }

    @DisplayName("로또 번호 생성시 로또 번호 생성 범위 넘었을 때 exception 테스트")
    @Test
    void createAnotherEdgeLottoNumberExceptionTest() {

        assertThatExceptionOfType(LottoNumberRangeException.class)
                .isThrownBy(() -> {
                    LottoNumber.of(0);
                }).withMessageMatching("로또 숫자는 1 ~ 45 사이의 숫자만 가능 합니다.");
    }
}