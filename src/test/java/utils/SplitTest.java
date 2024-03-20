package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SplitTest {

    @DisplayName("입력받은 문자열을 공백(스페이스) 문자로 split 할 수 있다")
    @Test
    void split() {
        final String input = "2 +  3 * 4 / 2";
        final String[] result = Splitter.byEmptySpace(input);

        assertThat(result).containsExactly("2", "+", "", "3", "*", "4", "/", "2");
    }

    @DisplayName("입력받은 문자열이 null 이거나 비어있다면 IllegalArgumentExcpetion을 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void throwExceptionWhenEmptyString(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Splitter.byEmptySpace(input));
    }
}
