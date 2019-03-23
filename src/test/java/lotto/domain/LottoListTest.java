package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    public void 로또_10개_발급() {
        final int lottosCount = 10;

        LottoList lottoList = new LottoList(lottosCount);

        assertThat(lottoList.size()).isEqualTo(lottosCount);
    }

    @Test(expected = RuntimeException.class)
    public void 로또_0개_발급() {
        new LottoList(0);
    }
}