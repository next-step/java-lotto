package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {
    @Test
    public void 자동_한_장() {
        // given
        final List<Lotto> lotteries = Arrays.asList(Lotto.automatic());

        // when
        final LottoPaper lottoPaper = new LottoPaper(lotteries);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(1);
        assertThat(lottoPaper.getAutomaticSize()).isEqualTo(1);
    }

    @Test
    public void 수동_세_장과_자동_두_장() {
        // given
        final List<Lotto> lotteries = Arrays.asList(
                Lotto.manual(new LottoNumbers(8, 21, 23, 41, 42, 43)),
                Lotto.manual(new LottoNumbers(3, 5, 11, 16, 32, 38)),
                Lotto.manual(new LottoNumbers(7, 11, 16, 35, 36, 44)),
                Lotto.automatic(),
                Lotto.automatic()
        );

        // when
        final LottoPaper lottoPaper = new LottoPaper(lotteries);

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(5);
        assertThat(lottoPaper.getManualSize()).isEqualTo(3);
        assertThat(lottoPaper.getAutomaticSize()).isEqualTo(2);
    }
}