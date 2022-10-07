package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {

    @Test
    @DisplayName("최소 입력 금액 검증")
    void invalidPrice() {
        assertThatThrownBy(() -> new UserInput(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
