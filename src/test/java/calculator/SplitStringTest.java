package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SplitStringTest {
    @Test
    void split_공백으로_구분() {
        List<String> result = SplitString.split("1 + 3 - 2 * 5 / 2");
        assertThat(result).isEqualTo(List.of("1", "+", "3", "-", "2", "*", "5", "/", "2"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void split_입력문자열_비어있는_경우(String elem) {
        assertThatThrownBy(() -> SplitString.split(elem)).isInstanceOf(IllegalArgumentException.class);
    }
}