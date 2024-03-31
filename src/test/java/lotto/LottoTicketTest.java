package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    public void 로또는_1_에서_45_까지의_숫자만_가질_수_있음() {
        assertThatThrownBy(
            () -> LottoTicket.createTicket(List.of(0, 1, 2, 33, 37, 45))).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("1이상 45이하의 숫자만 입력할 수 있습니다.");
    }

    @Test
    public void 로또는_6개의_숫자를_가짐() {
        assertThatThrownBy(() -> LottoTicket.createTicket(List.of(1, 2, 33, 44, 45))).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("로또 생성을 위해서는 6개의 숫자가 필요합니다.");
    }

    @Test
    public void 하나의_로또_안에서_숫자가_겹치지_않음() {
        assertThatThrownBy(
            () -> LottoTicket.createTicket(List.of(1, 1, 23, 34, 44, 45))).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("중복 값은 입력할 수 없습니다.");

    }

    @Test
    public void 로또_당첨_금액_계산() {
        LottoTicket lottoTicket = LottoTicket.createTicket(List.of(1, 2, 23, 34, 44, 45));
        List<Integer> winningNumbers = List.of(1, 2, 23, 24, 34, 44);

        LottoPrice price = lottoTicket.getPrice(new WinLotto(winningNumbers, 45));
        assertThat(price.getCount()).isEqualTo(5);
        assertThat(price.isBonusResult()).isTrue();
    }
}
