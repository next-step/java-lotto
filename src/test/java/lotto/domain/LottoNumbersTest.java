package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
public class LottoNumbersTest {
    @Test
    public void 생성() {
        assertThat(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
    }
}
