package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void 당첨번호_일치_개수() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.countMatch(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), 0)).isEqualTo(1);
    }

    @Test
    void 로또번호_일치_개수() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.countMatch(0, new LottoNumber(1))).isEqualTo(1);
    }

    @Test
    void 당첨번호_생성() {
        List<LottoNumber> winningNumbers = LottoNumber.createWinningNumbers("1, 2, 3, 4, 5, 6");
        assertThat(winningNumbers).isEqualTo(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }
}