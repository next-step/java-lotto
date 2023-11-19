package lotto;

import lotto.domain.MatchNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MatchNumbersTest {

    @DisplayName("생성된 matchNumbers객체에 0-6사이의 숫자를 전달하면 값을 추가할 수 있다.")
    @Test
    void matchNumbersTest() {
        MatchNumbers matchNumbers = new MatchNumbers();
        matchNumbers.add(0);
        matchNumbers.add(3);
        assertThat(matchNumbers.size()).isEqualTo(2);
    }

    @DisplayName("matchNumbers에 6을 넘는 숫자를 전달하면 Exception을 던진다.")
    @Test
    void matchNumbersOverErrorTest() {
        MatchNumbers matchNumbers = new MatchNumbers();
        assertThatThrownBy(() -> matchNumbers.add(7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("matchNumbers에 0이하의 숫자를 전달하면 Exception을 던진다.")
    @Test
    void matchNumbersUnderErrorTest() {
        MatchNumbers matchNumbers = new MatchNumbers();
        assertThatThrownBy(() -> matchNumbers.add(-7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
