package lotto.domain;

import lotto.dto.WinningResult;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningsTest {
    @Test
    void 당첨_결과() {
        List<Winning> list = List.of(new Winning(3, 0), new Winning(4, 0), new Winning(5, 0), new Winning(6, 0));
        assertThat(new Winnings(list).result(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))))).isEqualTo(new WinningResult(list, new BigDecimal("0.00")));
    }
}