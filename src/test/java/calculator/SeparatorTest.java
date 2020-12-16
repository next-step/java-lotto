package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {

    private PositiveNumbers expected;

    @BeforeEach
    void init() {
        PositiveNumber[] positiveNumberArray = Stream.of(
                new PositiveNumber("1"),
                new PositiveNumber("2"),
                new PositiveNumber("3"))
                .toArray(PositiveNumber[]::new);
        expected = new PositiveNumbers(positiveNumberArray);
    }

    @Test
    @DisplayName("쉼표_또는_콜론_구분자")
    void splitDefaultSeparator() {
        Separator separator = new DefaultSeparator();
        PositiveNumbers positiveNumbers = separator.split(new InputText("1,2:3"));
        assertThat(positiveNumbers).isEqualTo(expected);
    }

    @Test
    @DisplayName("custom_구분자")
    void splitCustomSeparator() {
        Separator separator = new CustomSeparator();
        PositiveNumbers positiveNumbers = separator.split(new InputText("//;\n1;2;3"));
        assertThat(positiveNumbers).isEqualTo(expected);
    }

}
