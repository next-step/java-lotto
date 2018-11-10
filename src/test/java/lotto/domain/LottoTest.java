package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 구매한_티켓_수_카운트_테스트() {
        Lotto lotto = new Lotto();
        int result = lotto.countTicket(14000);
        assertThat(result).isEqualTo(14);
    }

}