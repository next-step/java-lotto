package helper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class StringHelperTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void null_or_empty(String input) {
        assertThat(StringHelper.nullOrEmpty(input)).isEqualTo(true);
    }

    @ParameterizedTest(name = "패턴을 포함한 split")

    public void split_by_pattern(String input) {
        assertThat(StringHelper.nullOrEmpty(input)).isEqualTo(true);
    }

}