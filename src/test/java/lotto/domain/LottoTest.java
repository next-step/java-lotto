package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 당첨_개수() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getMatchNum(Lotto.from(List.of(1, 2, 3, 11, 12, 13)))).isEqualTo(3);
    }

    @Test
    void 로또_순서_검증() {
        Lotto lotto = Lotto.from(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.isSorted()).isTrue();
    }
}
