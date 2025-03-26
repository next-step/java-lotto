package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 50})
    public void 로또번호_범위_외의_수로_로또번호_객체_생성_시도시_예외발생(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(input));
    }
}
