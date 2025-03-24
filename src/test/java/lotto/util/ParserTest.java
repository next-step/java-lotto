package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @Test
    void 당첨_번호_입력() {
        assertThat(Parser.parseWinningNumbers("1,2,3,4,5,6")).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
