package lotto;

import lotto.domain.Lotto;
import lotto.dto.Money;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Before
    public void setUp() {
        Money.inputUserMoney(2000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_구입_1000원미만() {
        Money.inputUserMoney(999);
    }

    @Test
    public void 로또_구입() {
        Lotto.buy();
        assertThat(UserLotto.getTicketCount()).isEqualTo(2);
    }

    @Test
    public void 지난주당첨번호_셋팅() {
        WinningLotto.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(WinningLotto.getWinningLotto()).hasSize(6);
    }
}
