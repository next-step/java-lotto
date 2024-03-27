package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningTest {
    @Test
    void split() {
        String[] input = "1,2,3,4,5,6".split(",");
        assertThat(input).containsExactly("1","2","3","4","5","6");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨번호_개수(String input) {
        Winning winning = new Winning();
        assertThatIllegalArgumentException().isThrownBy(() -> winning.createWinNumbers(input))
                .withMessageMatching("당첨번호 개수는 6개여야 합니다.");
    }
}
