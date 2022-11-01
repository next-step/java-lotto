package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoNumber.valueOf;

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

    @Test
    void 로또번호_포함_불포함() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lottoTicket.contains(valueOf(1))).isSameAs(true);
        Assertions.assertThat(lottoTicket.contains(valueOf(7))).isSameAs(false);
    }

    @Test
    void 티켓을_넘겨받아_로또번호가_일치하는_갯수_반환() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket winningNumbers = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lottoTicket.countSameNumber(winningNumbers)).isEqualTo(6);
    }

}
