package StringAdder;

import org.junit.jupiter.api.Test;

import static StringAdder.StringAdderTestUtil.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdderTest {
    private final String EMPTY_STRING = "";
    private final int ZERO_VALUE = 0;
    private final int RESULT_SINGLE_NUMBER = 1;
    private final int RESULT_MULTIPLE_NUMBER = 15;
    private final String INPUT_COMPOSED_OF_ONE_NUMBER = "1";

    @Test
    void testNullInput() {
        assertThat(new Adder(null).add()).isEqualTo(new Num(ZERO_VALUE));
    }

    @Test
    void testEmptyInput() {
        assertThat(new Adder(EMPTY_STRING).add()).isEqualTo(new Num(ZERO_VALUE));
    }

    @Test
    void testInputComposedOfOneNumber() {
        assertThat(new Adder(INPUT_COMPOSED_OF_ONE_NUMBER).add()).isEqualTo(new Num(RESULT_SINGLE_NUMBER));
    }

    @Test
    void testInputWithComma() {
        assertThat(new Adder(INPUT_WITH_COMMA).add()).isEqualTo(new Num(RESULT_MULTIPLE_NUMBER));
    }

    @Test
    void testInputWithColon() {
        assertThat(new Adder(INPUT_WITH_COLON).add()).isEqualTo(new Num(RESULT_MULTIPLE_NUMBER));
    }

    @Test
    void testInputMixedWithCommaAndColon() {
        assertThat(new Adder(INPUT_WITH_COLON).add()).isEqualTo(new Num(RESULT_MULTIPLE_NUMBER));
    }

    @Test
    void testInputWithCustomSeparator() {
        assertThat(new Adder(INPUT_WITH_CUSTOM_SEPARATOR).add()).isEqualTo(new Num(RESULT_MULTIPLE_NUMBER));
    }

    @Test
    void testInputWithCustomSeparatorAndBasicSeparator() {
        assertThat(new Adder(INPUT_WITH_CUSTOM_SEPARATOR_AND_BASIC_SEPARATOR).add()).isEqualTo(new Num(RESULT_MULTIPLE_NUMBER));
    }
}
