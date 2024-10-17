package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 당첨번호와_일치하는_번호_세기() {
        Lotto lotto = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        assertThat(lotto.countMatch(LottoNumber.createWinningNumbers("1, 2, 3, 4, 5, 6"))).isEqualTo(6);
    }
}
