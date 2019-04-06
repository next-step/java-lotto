package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPaper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

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
        final LottoPaper lottoPaper = lottoService.issue(14_000, Collections.EMPTY_LIST);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(14);
    }

    @Test
    public void 구입_금액이_영_원일_때() {
        // given
        // when
        final LottoPaper lottoPaper = lottoService.issue(0, Collections.EMPTY_LIST);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(0);
    }

    @Test
    public void 한_장_구입해서_일등() {
        // given
        final LottoPaper lottoPaper = new LottoPaper(
                Arrays.asList(
                        Lotto.manual(new LottoNumbers(1, 2, 3, 4, 5, 6))
                )
        );

        // when
        final ResultView view = lottoService.viewResults(lottoPaper, "1, 2, 3, 4, 5, 6", 7);

        // then
        assertThat(view.getRoi()).isEqualTo(2_000_000);
    }

    @Test
    public void 한_장_구입해서_이등() {
        // given
        final LottoPaper lottoPaper = new LottoPaper(
                Arrays.asList(
                        Lotto.manual(new LottoNumbers(1, 2, 3, 4, 5, 6))
                )
        );

        // when
        final ResultView view = lottoService.viewResults(lottoPaper, "1, 2, 3, 4, 5, 7", 6);

        // then
        assertThat(view.getRoi()).isEqualTo(30_000);
    }

    @Test
    public void 여섯_장_구입해서_오등_한_장() {
        // given
        final LottoPaper lottoPaper = new LottoPaper(
                Arrays.asList(
                        Lotto.manual(new LottoNumbers(1, 2, 3, 4, 5, 6)),
                        Lotto.manual(new LottoNumbers(11, 12, 13, 14, 15, 16)),
                        Lotto.manual(new LottoNumbers(11, 12, 13, 14, 15, 16)),
                        Lotto.manual(new LottoNumbers(11, 12, 13, 14, 15, 16)),
                        Lotto.manual(new LottoNumbers(11, 12, 13, 14, 15, 16)),
                        Lotto.manual(new LottoNumbers(11, 12, 13, 14, 15, 16))
                )
        );

        // when
        final ResultView view = lottoService.viewResults(lottoPaper, "1, 2, 3, 7, 8, 9", 6);

        // then
        assertThat(view.getRoi()).isEqualTo(0.83);
    }
}
