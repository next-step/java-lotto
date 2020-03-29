package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class InputViewTest {

    @DisplayName("사용자의 입력을 받을 수 있다.")
    @Test
    void testCanCreate() {
        new InputView(1000);
    }

    @DisplayName("사용자가 입력한 값이 1000보다 커야한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 500})
    void testPriceMoreThanThousand(final int price) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new InputView(price));
    }
}
