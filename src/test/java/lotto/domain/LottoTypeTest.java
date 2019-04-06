package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTypeTest {
    @Test
    public void 자동() {
        // given
        final LottoType lottoType = LottoType.AUTOMATIC;

        // when
        final boolean automatic = lottoType.isAutomatic();

        // then
        assertThat(automatic).isTrue();
    }

    @Test
    public void 수동() {
        // given
        final LottoType lottoType = LottoType.MANUAL;

        // when
        final boolean manual = lottoType.isManual();

        // then
        assertThat(manual).isTrue();
    }
}