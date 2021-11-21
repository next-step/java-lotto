package calculator.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AssertTest {

    @ParameterizedTest
    @NullAndEmptySource
    void notNull(String message) {
        assertThatThrownBy(() -> {
            Assert.notNull(null, message);
        });
    }

}