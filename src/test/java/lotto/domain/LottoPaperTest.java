package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {
    @Test
    public void 로또_발급() {
        // given
        final Money amount = Money.from(14_000);

        // when
        final LottoPaper lottoPaper = LottoPaper.issue(amount, Collections.EMPTY_LIST);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(14);
        assertThat(lottoPaper.getAutomaticSize()).isEqualTo(14);
    }

    @Test
    public void 로또_일부_수동_발급() {
        // given
        final Money amount = Money.from(14_000);
        final List<LottoNumbers> numbers = Arrays.asList(
                new LottoNumbers(8, 21, 23, 41, 42, 43),
                new LottoNumbers(3, 5, 11, 16, 32, 38),
                new LottoNumbers(7, 11, 16, 35, 36, 44)
        );

        // when
        final LottoPaper lottoPaper = LottoPaper.issue(amount, numbers);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(14);
        assertThat(lottoPaper.getAutomaticSize()).isEqualTo(11);
        assertThat(lottoPaper.getManualSize()).isEqualTo(3);
    }
}