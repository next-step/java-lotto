package step01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BlankTest {

    @ParameterizedTest
    @NullSource
    public void test_isNull(String input) {
        assertThat(Blank.isNull(input)).isTrue();
    }

    @ParameterizedTest
    @EmptySource
    public void test_isEmpty(String input) {
        assertThat(Blank.isEmpty(input)).isTrue();
    }
}
