package lotto.util;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoNumberParserTest {
    @Test
    public void 중복_숫자() {
        assertThatThrownBy(() -> LottoNumberParser.parse("1, 2, 2, 3, 4, 5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자_개수_부족() {
        assertThatThrownBy(() -> LottoNumberParser.parse("1, 2, 3, 4, 5")).isInstanceOf(IllegalArgumentException.class);
    }
}
