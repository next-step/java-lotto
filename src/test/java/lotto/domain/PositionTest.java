package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 100})
    @DisplayName("비 정상적인 값으로 Position이 생성될때 illegalArgumentException이 발생하는지 확인합니다.")
    void illegalArgument(int value) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    new Position(value);
                }
        );
    }

}