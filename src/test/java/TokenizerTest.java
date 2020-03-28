import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TokenizerTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
    public void splitTest(String message) {
        List<Integer> tokens = Tokenizer.split(message);
        assertThat(tokens).hasSize(3);
        assertThat(tokens).contains(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1@2,3", "1!2:3", "1!2!3", "1@2@3"})
    public void wrongMessageSplitThrowException(String message) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Tokenizer.split(message);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1:-2:3", "1,2:-3", "-1:-2,-3"})
    public void negativeNumberSplitThrowException(String message) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Tokenizer.split(message);
                }).withMessage("음수는 계산할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "a:b:c", "A,B,C", "A,b,C"})
    public void stringMessageSplitThrowException(String stringMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Tokenizer.split(stringMessage);
                }).withMessage("문자열은 계산할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1@2@3, @", "1!2!3, !", "1#2#3, #"})
    public void customDelimiterSplitTest(String message, String delimiter) {
        List<Integer> tokens = Tokenizer.split(message, delimiter);
        assertThat(tokens).hasSize(3);
        assertThat(tokens).contains(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "!", "#", ";"})
    public void wrongDelimiterCustomDelimiterSplitThrowException(String delimiter) {
        String message = "1,2:3";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Tokenizer.split(message, delimiter);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"-1@2@3, @", "1!-2!3, !", "1#2#-3, #"})
    public void negativeNumberCustomDelimiterSplitThrowException(String message, String delimiter) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Tokenizer.split(message, delimiter);
                }).withMessage("음수는 계산할 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"a@b@c, @", "X!y!z, !", "D#E#[#]#{#}, #"})
    public void stringMessageCustomDelimiterSplitThrowException(String message, String delimiter) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Tokenizer.split(message, delimiter);
                }).withMessage("문자열은 계산할 수 없습니다.");
    }

}
