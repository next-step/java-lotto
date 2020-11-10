package lotto.domain.lotto;

import lotto.domain.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("돈 테스트")
public class MoneyTest {

    @DisplayName("0이하로 돈 생성")
    @ParameterizedTest
    @CsvSource(value = {"-1", "0"})
    public void invalidMoneyAmount(int amount) {
        assertThatThrownBy(() -> {
            Money.of(amount);
        }).isInstanceOf(InvalidMoneyException.class)
                .hasMessageContaining("금액은 0보다 커야합니다.");
    }
}