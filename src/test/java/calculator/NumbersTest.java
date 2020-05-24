package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class NumbersTest {

    @DisplayName("Numbers 컬렉션 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3:4:5", "//!\n1!3!9"})
    public void makeNumbersObject(String input) {
        List<Integer> parsedNumbers = StringParser.parseString(input);
        assertThatCode(() -> {
            Numbers numbers = new Numbers(parsedNumbers);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Numbers 컬렉션의 합을 구하는 테스트")
    @ParameterizedTest
    @MethodSource("mockUserInputBuilder")
    public void getNumbersSum(String input, int sum) {
        Numbers numbers = new Numbers(StringParser.parseString(input));

        assertThat(numbers.getNumbersSum()).isEqualTo(sum);
    }

    private static Stream<Arguments> mockUserInputBuilder() {
        return Stream.of(
                Arguments.of("1:2:3:4:5", 15),
                Arguments.of("//k\n100k200k300", 600),
                Arguments.of("0,0:0", 0)
        );
    }
}
