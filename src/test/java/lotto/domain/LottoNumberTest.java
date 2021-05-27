package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 *  로또번호 생성 테스트
 */
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,44,45})
    @DisplayName("미리 생성해둔 로또번호 객체 재사용")
    void lottoNumber_of(int lottoNumber) {
        assertThat(LottoNumber.of(lottoNumber)).isSameAs(LottoNumber.of(lottoNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또번호의 값 범위 유효성을 검증한다.")
    void validate_lotto_number(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 45})
    @DisplayName("생성된 로또번호의 값을 검증한다.")
    void get_lotto_number(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("로또번호를 생성한다.")
    void create_lotto_number() {
        int number = 1;
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isNotNull();
    }
}
