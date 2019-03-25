package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPaper;
import lotto.domain.WinningOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;

    @Before
    public void setUp() {
        this.lottoService = new LottoService();
    }

    @Test
    public void 구입_금액에_해당하는_로또_발급() {
        // given
        // when
        final LottoPaper lottoPaper = lottoService.issue(14000);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(14);
    }

    @Test
    public void 구입_금액이_영_원일_때() {
        // given
        // when
        final LottoPaper lottoPaper = lottoService.issue(0);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(0);
    }

    @Test
    public void 한_장_구입해서_일등() {
        // given
        final LottoPaper lottoPaper = new LottoPaper(Arrays.asList(Lotto.manual(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))));

        // when
        final ResultView view = lottoService.viewResults(lottoPaper, "1, 2, 3, 4, 5, 6", 7);

        // then
        assertThat(view.getRoi()).isEqualTo(WinningOrder.FIRST_PLACE.getAmount().divide(Lotto.PRICE));
    }

    @Test
    public void 한_장_구입해서_이등() {
        // given
        final LottoPaper lottoPaper = new LottoPaper(Arrays.asList(Lotto.manual(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))));

        // when
        final ResultView view = lottoService.viewResults(lottoPaper, "1, 2, 3, 4, 5, 7", 6);

        // then
        assertThat(view.getRoi()).isEqualTo(WinningOrder.SECOND_PLACE.getAmount().divide(Lotto.PRICE));
    }
}
