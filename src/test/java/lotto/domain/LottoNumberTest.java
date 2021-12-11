package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또를 구성하는 각 번호 `LottoNumber`에 대한 테스트")
class LottoNumberTest {

    @DisplayName("`LottoNumber` 생성")
    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER})
    void createLottoNumberTest(int expected) {
        // when
        LottoNumber lottoNumber = new LottoNumber(expected);
        // then
        assertAll(
                () -> assertThat(lottoNumber).isNotNull(),
                () -> assertThat(lottoNumber.getNumber()).isEqualTo(expected)
        );
    }

    @DisplayName("`LottoNumber` 생성시, 유효하지 않는 값 전달로 예외 발생 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, LottoNumber.MIN_NUMBER - 1, LottoNumber.MAX_NUMBER + 1, Integer.MAX_VALUE})
    void checkExceptionForInvalidLottoNumberTest(int expected) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumber(expected)
        );
    }
}
