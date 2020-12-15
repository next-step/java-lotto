package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {

    @Test
    @DisplayName("쉼표_또는_콜론_구분자")
    void splitDefaultSeparator() {
        Separator separator = new DefaultSeparator();
        PositiveNumbers positiveNumbers = separator.split(new InputText("1,2:3"));
        assertThat(positiveNumbers).isEqualTo(new PositiveNumbers(new PositiveNumber[] {
                new PositiveNumber("1"), new PositiveNumber("2"), new PositiveNumber("3")}
        ));
    }

    @Test
    @DisplayName("custom_구분자")
    void splitCustomSeparator() {
        Separator separator = new CustomSeparator();
        PositiveNumbers positiveNumbers = separator.split(new InputText("//;\n1;2;3"));
        assertThat(positiveNumbers).isEqualTo(new PositiveNumbers(new PositiveNumber[] {
                new PositiveNumber("1"), new PositiveNumber("2"), new PositiveNumber("3")}
        ));
    }

}
