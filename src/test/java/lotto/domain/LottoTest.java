package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 당첨_개수() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getMatchNum(new Lotto(List.of(1, 2, 3, 11, 12, 13)))).isEqualTo(3);
    }
}
