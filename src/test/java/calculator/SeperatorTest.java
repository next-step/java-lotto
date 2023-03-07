package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class SeperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"//[\\n1[2[3=1-2-3", "//*\\n1*2*8=1-2-8", "1,2,3,4=1-2-3-4",
        "1,2,3:4=1-2-3-4"},delimiter = '=')
    void normalFunctionalTest(String str, String result) {
        Seperator seperator = new Seperator(str);
        assertThat(seperator.getSperatedValue()).isEqualTo(result.split("-"));
    }

}
