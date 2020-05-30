package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 숫자를 생성하는데 어떤 에러도 발생하지 않는다.")
    void 로또_숫자_생성_테스트() {
        assertThatCode(() -> LottoNumber.of(8)).doesNotThrowAnyException();
    }

    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    @DisplayName("로또 숫자를 생성하는데 범위가 벗어나면 예외가 발생한다.")
    void 로또_숫자_생성_예외_테스트(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(value));
    }

    @Test
    @DisplayName("로또 숫자 리스트의 크기를 검증한다.")
    void 로또_숫자_리스트_테스트() {
        assertThat(LottoNumber.getDefaultLottoNumbers()).hasSize(LottoNumber.LOTTO_NUMBER_MAX);
    }

    @Test
    @DisplayName("로또 번호 검증 메소드 테스트")
    void 로또_번호_검증_테스트() {
        assertThat(LottoNumber.isValidNumber(1)).isTrue();
        assertThat(LottoNumber.isValidNumber(0)).isFalse();
        assertThat(LottoNumber.isValidNumber(46)).isFalse();
    }
}
