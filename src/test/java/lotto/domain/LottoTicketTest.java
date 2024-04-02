package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
            IllegalArgumentException.class).hasMessageContaining("6개의 숫자가 필요합니다.");
    }

    @Test
    public void 하나의_로또_안에서_숫자가_겹치지_않음() {
        assertThatThrownBy(
            () -> LottoTicket.createTicket(List.of(1, 1, 23, 34, 44, 45))).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("중복 값은 입력할 수 없습니다.");

    }
}
