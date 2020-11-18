package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TokenizerTest {
    @DisplayName("입력받은 WinningNumbers 를 토큰화")
    @Test
    public void test_execute() {
        assertThat(
                Tokenizer.execute("1, 2, 3, 4, 5")
        ).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }
}
