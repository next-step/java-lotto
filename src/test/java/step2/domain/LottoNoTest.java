package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 32, 45})
    public void 로또번호객체_생성(int number) throws Exception {
        assertThat(LottoNo.of(number)).isEqualTo(LottoNo.of(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100, -100})
    public void 로또번호객체_생성_예외(int number) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNo.of(number));
    }
}
