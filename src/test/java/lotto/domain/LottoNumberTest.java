package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 번호(LottoNumber) 테스트")
public class LottoNumberTest {

    @DisplayName("로또 번호는 1 ~ 45 범위의 숫자 하나를 의미한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void create(int value) {
        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(value);

        // then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("로또 번호가 1 ~ 45 이외일 경우 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createOutOfRange(int value) {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.valueOf(value));
    }

    @DisplayName("로또 번호가 같으면 동일성을 보장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void equals(int value) {
        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(value);
        LottoNumber other = LottoNumber.valueOf(value);

        // then
        assertThat(lottoNumber).isEqualTo(other);
    }

    @DisplayName("캐싱을 통해 동일한 객체임을 보장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void cache(int value) {
        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(value);
        LottoNumber other = LottoNumber.valueOf(value);

        // then
        assertThat(lottoNumber).isSameAs(other);
    }
}
