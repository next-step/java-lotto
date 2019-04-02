package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 자동_생성() {
        // given
        // when
        final Lotto lotto = Lotto.automatic();

        // then
        assertThat(lotto.isAutomatic()).isTrue();
    }

    @Test
    public void 수동_생성() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        // when
        final Lotto lotto = Lotto.manual(lottoNumbers);

        // then
        assertThat(lotto.isManual()).isTrue();
    }

    @Test
    public void 낙첨() {
        // given
        final LottoNumbers numbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        final Lotto lotto = Lotto.manual(numbers);
        final WinningNumber winningNumber = new WinningNumber(new LottoNumbers(7, 8, 9, 10, 11, 12), LottoNumber.from(13));

        // when
        final WinningOrder winningOrder = lotto.winResult(winningNumber);

        // then
        assertThat(winningOrder).isEqualTo(WinningOrder.LAST_PLACE);
    }

    @Test
    public void 오등_당첨() {
        // given
        final LottoNumbers numbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        final Lotto lotto = Lotto.manual(numbers);
        final WinningNumber winningNumber = new WinningNumber(new LottoNumbers(1, 2, 3, 7, 8, 9), LottoNumber.from(13));

        // when
        final WinningOrder winningOrder = lotto.winResult(winningNumber);

        // then
        assertThat(winningOrder).isEqualTo(WinningOrder.FIFTH_PLACE);
    }

    @Test
    public void 일등_당() {
        // given
        final LottoNumbers numbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        final Lotto lotto = Lotto.manual(numbers);
        final WinningNumber winningNumber = new WinningNumber(numbers, LottoNumber.from(13));

        // when
        final WinningOrder winningOrder = lotto.winResult(winningNumber);

        // then
        assertThat(winningOrder).isEqualTo(WinningOrder.FIRST_PLACE);
    }
}
