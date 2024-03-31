package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.Test;

public class WinLottoTest {


    @Test
    public void 당첨_로또_생성() {
        List<Integer> winningNumber = List.of(1, 2, 3, 23, 34, 42);
        WinLotto winLotto = new WinLotto(winningNumber, 43);
        for (int i = 0; i < winLotto.getTicket().getNumbers().size(); i++) {
            assertThat(winLotto.getTicket().getNumbers().get(i)).isEqualTo(
                new LottoNumber(winningNumber.get(i)));
        }
        assertThat(winLotto.getBonusNumber()).isEqualTo(new LottoNumber(43));
    }

    @Test
    public void 보너스번호는_당첨번호에_포함_불가() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 23, 34, 42), 3)).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("보너스번호는 당첨번호에 포함될 수 없습니다.");
    }

}
