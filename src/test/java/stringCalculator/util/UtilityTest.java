package stringCalculator.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UtilityTest {

    static Utility utility;

    @BeforeAll
    static void setUp() {
        utility = new Utility();
    }

    @DisplayName("식 분리 테스트")
    @ParameterizedTest
    @MethodSource("provideSplitEquationTest")
    public void splitEquationTest(String[] actual, String[] expected) {
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> provideSplitEquationTest() {
        return Stream.of(
                Arguments.of(utility.splitEquation("1,2,3"), new String[]{"1", "2", "3"}),
                Arguments.of(utility.splitEquation("1:2:3"), new String[]{"1", "2", "3"}),
                Arguments.of(utility.splitEquation("1,2:3"), new String[]{"1", "2", "3"}),
                Arguments.of(utility.splitEquation("//;\n1;2;3"), new String[]{"1", "2", "3"})
        );
    }
}
