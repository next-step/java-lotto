package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {

    @Test
    @DisplayName("쉼표_또는_콜론_구분자")
    void splitDefaultSeparator() {
        Separator separator = new DefaultSeparator();
        Tokens tokens = separator.split(new InputText("1,2:3"));
        assertThat(tokens).isEqualTo(new Tokens(new Token[] {
                new Token("1"), new Token("2"), new Token("3")}
        ));
    }

    @Test
    @DisplayName("custom_구분자")
    void splitCustomSeparator() {
        Separator separator = new CustomSeparator();
        Tokens tokens = separator.split(new InputText("//;\n1;2;3"));
        assertThat(tokens).isEqualTo(new Tokens(new Token[] {
                new Token("1"), new Token("2"), new Token("3")}
        ));
    }

}
