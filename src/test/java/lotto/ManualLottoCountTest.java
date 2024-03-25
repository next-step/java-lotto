package lotto;

import lotto.domain.Amount;
import lotto.domain.ManualLottoCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ManualLottoCountTest {
    private Amount amount;

    @BeforeEach
    void setUp() {
        amount = new Amount("3000");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "3,3"})
    void 수동로또개수_생성(String input, int expected) {
        ManualLottoCount manualLottoCount = new ManualLottoCount(input, amount);
        assertThat(manualLottoCount.value()).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "-1", "4", "1.5", "a"})
    void 적절하지_않은_수동로또개수_생성(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ManualLottoCount(input, amount));
    }
}
