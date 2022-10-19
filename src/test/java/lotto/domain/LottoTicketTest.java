package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTicketTest {

    @Test
    void 로또_생성_사이즈() {
        List<Integer> zeroSizeList = new ArrayList<>();
        Assertions.assertThatThrownBy(() -> new LottoTicket(zeroSizeList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_중복번호() {
        List<Integer> duplicateNumberList = List.of(1, 1, 2, 3, 4, 5);
        Assertions.assertThatThrownBy(() -> new LottoTicket(duplicateNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
