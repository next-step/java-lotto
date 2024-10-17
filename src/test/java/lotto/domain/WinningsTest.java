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
        assertThat(new Winnings(list).result(List.of(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))))).isEqualTo(new WinningResult(list, new BigDecimal("0.00")));
    }
}