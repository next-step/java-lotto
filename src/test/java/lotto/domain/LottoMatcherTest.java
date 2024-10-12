package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    @Test
    @DisplayName("1, 4 일치")
    void 로또번호_당첨갯수_2개() {
        Lotto user = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto("1, 4, 8, 9, 10, 11");

        int result = LottoMatcher.match(user, winningNumber);
        assertThat(result).isEqualTo(2);
    }
}
