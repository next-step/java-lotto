package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.util.ReflectionTestUtils;

class UserPriceTest {

    @ParameterizedTest
    @CsvSource({"0, false", "2000, true", "100000, true", "200000, false"})
    public void validateUserPriceTest(String input, String expected) {
        //when
        Throwable thrown = catchThrowable(() -> new UserPrice(Integer.valueOf(input)).validateUserPrice());

        //then
        if (false == Boolean.valueOf(expected)) {
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        }
    }
}

