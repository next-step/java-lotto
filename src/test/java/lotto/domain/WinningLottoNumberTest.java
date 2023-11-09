package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumberTest {

    @Test
    void 당첨로또번호로_구입로또_등수를_알_수_있다() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1, 2, 3, 4, 5, 6));
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(List.of(1, 2, 3, 4, 5, 6));

        LottoRank actual = winningLottoNumber.winningRank(lottoNumber);
        LottoRank expected = LottoRank.FIRST;

        assertThat(actual).isEqualTo(expected);
    }
}
