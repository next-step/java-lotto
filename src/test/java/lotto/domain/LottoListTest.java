package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    public void 로또_10개_발급() {
        LottoList lottoList = new LottoList(10);

        assertThat(lottoList.size()).isEqualTo(10);
    }

    @Test(expected = RuntimeException.class)
    public void 로또_0개_발급() {
        new LottoList(0);
    }
}