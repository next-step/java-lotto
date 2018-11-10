package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.utils.LottoHelper;
import org.junit.Test;

public class LottoTest {

    @Test
    public void 로또복권_생성_검증() {
        Lotto ticket1 = new Lotto(LottoHelper.convertToBalls("1,2,3,4,5,6"));
        assertThat(ticket1.getNumbers().size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자리수부족_로또복권_생성_검증() {
        Lotto ticket1 = new Lotto(LottoHelper.convertToBalls("1,2,3"));
    }

}
