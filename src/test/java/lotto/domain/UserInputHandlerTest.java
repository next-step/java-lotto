package lotto.domain;

import lotto.domain.UserInputHandler;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UserInputHandlerTest {
    @Test
    void 돈을_입력할때는_숫자로_입력() {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    UserInputHandler.scanMoney("a");
                });
    }
}
