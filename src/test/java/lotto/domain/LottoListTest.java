package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    public void LottoTicket() {
        final int lottosCount = 10;

        LottoList lottoList = new LottoList(lottosCount);

        assertThat(lottoList.size()).isEqualTo(lottosCount);
    }

    @Test(expected = RuntimeException.class)
    public void LottoTicket_로또_발급_갯수가_0이하() {
        final int lottosCount = 0;

        LottoList lottoList = new LottoList(lottosCount);

        assertThat(lottoList.size()).isEqualTo(lottosCount);
    }
}