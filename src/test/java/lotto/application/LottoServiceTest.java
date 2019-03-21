package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPaper;
import lotto.domain.WinningOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    public void 여섯_개_일치() {
        // given
        final LottoNumbers lottoNumbers = LottoNumbers.randomNumbers();
        final LottoPaper lottoPaper = new LottoPaper(Arrays.asList(Lotto.manual(lottoNumbers)));
        final String winningNumber = lottoNumbersToString(lottoNumbers);

        // when
        final ResultView view = lottoService.viewResults(lottoPaper, winningNumber);

        // then
        assertThat(view.getRoi()).isEqualTo(WinningOrder.FIRST_PLACE.getAmount() / Lotto.PRICE);
    }

    private String lottoNumbersToString(final LottoNumbers lottoNumbers) {
        return lottoNumbers.get()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
                ;
    }
}
