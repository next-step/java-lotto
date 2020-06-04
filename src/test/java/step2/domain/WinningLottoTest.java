package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.util.ReflectionTestUtils;

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(value = {"a,b,c,d,e,f/false", "a,1,2,3,4,5/false", "1,2,3,4,5,/false",
        "1,2,3,4,5,6/true"}, delimiter = '/')
    public void validateWinningNumbersTest(String input, String expected) {
        //when
        Throwable thrown = catchThrowable(() ->
            ReflectionTestUtils
                .invokeMethod(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    "validateWinningNumbers",
                    Integer.valueOf(input)));

        //then
        if (false == Boolean.valueOf(expected)) {
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        }
    }
}