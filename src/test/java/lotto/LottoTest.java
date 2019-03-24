package lotto;

import lotto.domain.Lotto;
import lotto.dto.Money;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;
import lotto.rule.LottoSetUp;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() {
        LottoSetUp.setUpLottoRule(6,45,1000);
        lotto = new Lotto(new Money(2555));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_구입_1000원미만() {
        Money money = new Money(500);
    }

    @Test
    public void 로또_구입() {
        lotto.buy();
        UserLotto userLotto = lotto.getUserLotto();
        assertThat(userLotto.getTicketCount()).isEqualTo(2);
    }

    @Test
    public void 지난주당첨번호_셋팅() {
        List<Integer> inputWinningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        lotto.winningLotto(inputWinningLotto);

        WinningLotto winningLotto = lotto.getWinningUserLotto();
        assertThat(winningLotto.getWinningLotto()).hasSize(6);
        assertThat(winningLotto.getWinningLotto().stream().filter(number -> number > 6)).isEmpty();
    }
}
