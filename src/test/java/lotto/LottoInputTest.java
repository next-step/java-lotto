package lotto;

import lotto.view.LottoInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoInputTest {

    LottoInput lotto;

    @BeforeEach
    public void setup() {
        lotto = new LottoInput();
    }

    @DisplayName("로또구입금액 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "lotto test", "-1", "120000"})
    public void purchaseValid(String amount) {
        assertThatThrownBy(() -> {
            lotto.purchaseValid(amount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또구입금액 테스트")
    @Test
    public void purchase() {
        assertThat(lotto.purchaseValid("10000")).isEqualTo(10000);

    }
}
