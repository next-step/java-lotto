package calculator.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "f"})
    void 숫자가_아닌_값이_들어올_경우(String value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 숫자가_비어있을때(String value) {
        assertThatThrownBy(() -> new Number(value))
                .isInstanceOf(IllegalStateException.class);
    }
}
