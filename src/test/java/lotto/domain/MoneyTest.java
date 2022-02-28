package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("돈_객체_생성시_주입받은_필드_값에_대한_예외_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"900", "-2", "abc"})
    void createMoneyTest(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(value));
    }
}
