package step01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BlankTest {

    @NullSource
    @Test
    public void test_isNull(String input) {
        assertThat(Blank.isNull(input)).isTrue();
    }

    @EmptySource
    @Test
    public void test_isEmpty(String input) {
        assertThat(Blank.isEmpty(input)).isTrue();
    }
}
