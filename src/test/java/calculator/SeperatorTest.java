package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class SeperatorTest {

    @Test
    void basicSeperatorTest() {
        String origin = "1,2,3";

        Seperator seperator = new Seperator(origin);
        assertThat(",|;".equals(seperator.getSeperator())).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void originInputBlankAndNullChkTest(String origin) {
        assertThatThrownBy(() -> {
            Seperator s = new Seperator(origin);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"//[\\n1[2[3=[", "//*\\n1*2*3=*"}, delimiter = '=')
    void customSeperatorTest(String origin, String value) {
        Seperator seperator = new Seperator(origin);
        assertThat(value.equals(seperator.getSeperator())).isTrue();
    }

}
