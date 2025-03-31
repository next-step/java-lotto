package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTicketTest {

    @Test
    @DisplayName("빈 로또티켓을 생성할 수 없다.")
    void createEmptyLottoTicket() {
        Assertions.assertThatThrownBy(() -> new LottoTicket(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
