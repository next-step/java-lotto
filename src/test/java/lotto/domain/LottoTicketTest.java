package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void 로또_넘버_6개가_아닐때_예외를_반환한다() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> new LottoTicket(integers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 넘버는 6개여야 합니다.");
    }

    @Test
    void 로또_넘버_중복일때_예외를_반환한다() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> new LottoTicket(integers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 넘버는 중복이 불가합니다.");
    }
}