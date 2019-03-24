package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void 당첨_번호와_추가_번호가_중복() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");

        // when
        // then
        new WinningNumber(lottoNumbers, LottoNumber.from(1));
    }

    @Test
    public void 일등() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        final WinningNumber winningNumber = new WinningNumber(lottoNumbers, LottoNumber.from(7));

        // when
        final WinningOrder winningOrder = winningNumber.winResult(lottoNumbers);

        // then
        assertThat(winningOrder).isEqualTo(WinningOrder.FIRST_PLACE);
    }

    @Test
    public void 이등() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        final LottoNumbers numbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        final WinningNumber winningNumber = new WinningNumber(numbers, LottoNumber.from(6));

        // when
        final WinningOrder winningOrder = winningNumber.winResult(lottoNumbers);

        // then
        assertThat(winningOrder).isEqualTo(WinningOrder.SECOND_PLACE);
    }
}
