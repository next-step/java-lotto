package step1.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void isEmpty_ReturnTrue(String target) {
        assertThat(StringUtils.isEmpty(target)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Not", "Empty", " Also", "  NotEmpty  " })
    public void isEmpty_ReturnFalse(String target) {
        assertThat(StringUtils.isEmpty(target)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = { "0,0", "10,10", "-1,-1", "50,50" })
    public void parseInt(String target, int result) {
        assertThat(StringUtils.parseInt(target)).isEqualTo(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "w", "r", "o", "n", "g", "\n", "yep" })
    public void parseInt_ShouldThrow_RuntimeException(String target) {
        assertThatThrownBy(() -> StringUtils.parseInt(target)).isInstanceOf(RuntimeException.class);
    }
}
