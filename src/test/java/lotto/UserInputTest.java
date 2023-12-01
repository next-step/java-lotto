package lotto;

import lotto.domain.UserInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {
    @DisplayName("수동금액이 크면오류")
    @Test
    void 수동금액이크면오류() {
        assertThatThrownBy(() -> {
            new UserInput(5_000, 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
