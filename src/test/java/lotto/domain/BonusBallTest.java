package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.NotPositiveException;
import lotto.strategy.ManualNumberStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BonusBallTest {

    private static Lotto winningLotto;

    @BeforeAll
    static void beforeAll() {
        winningLotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void Null_또는_Blank(String input) {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new BonusBall(input, winningLotto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 음수_또는_0(String input) {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new BonusBall(input, winningLotto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 중복(String input) {
        assertThatExceptionOfType(DuplicateLottoNumberException.class)
                .isThrownBy(() -> new BonusBall(input, winningLotto));
    }
}