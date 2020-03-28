package lotto;

import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputViewTest {
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullOrEmptyTest(String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new InputView(input);
        });
    }
}
