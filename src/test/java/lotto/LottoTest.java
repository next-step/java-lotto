package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    @Test
    @DisplayName("로또 생성시 number size가 유효하지 않으면 throw IllegalStateException")
    void createTest_invalidNumberSize() {
        assertAll(
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5))),
                () -> assertThatExceptionOfType(IllegalStateException.class)
                        .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
        );
    }
}
