package lotto;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.WinningLotto;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ManualStrategyTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "1, 2, 3", "1, 2, 3, 4, 5, 46"})
    public void 지난_로또_결과_입력_실패(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(LottoNumber.of(7), new ManualStrategy(input)));

    }


    @ParameterizedTest
    @ValueSource(strings = {"45,44,43,42,41,40", "1, 2, 3, 4,5 , 6"})
    public void 지난_로또_결과_입력_성공(String input) {
        assertThat(new WinningLotto(LottoNumber.of(7), new ManualStrategy(input))).isNotNull();
    }
}
