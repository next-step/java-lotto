package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    @Test
    void 여섯개의_서로_다른_숫자() {
        assertThat(LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(LottoTicket.create(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        assertThat(LottoTicket.createFromIntegerList(List.of(1, 20, 30, 40, 45, 16))).isInstanceOf(LottoTicket.class);
    }

    @Test
    void 중복된_숫자가_포함되면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.createFromIntegerList(List.of(1, 1, 1, 1, 1, 1)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.createFromIntegerList(List.of(1, 1, 2, 3, 4, 5)));
    }

    @Test
    void 목록에_포함된_숫자가_6개가_아니면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.createFromIntegerList(new ArrayList<>()));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.createFromIntegerList(List.of(1)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 공통된_숫자_갯수_반환() {
        LottoTicket winningTicket = LottoTicket.createFromIntegerList(List.of(1, 2, 3, 4, 5, 6));

        assertThat(
                LottoTicket.createFromIntegerList(List.of(11, 12, 13, 14, 15, 16)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(0);

        assertThat(
                LottoTicket.createFromIntegerList(List.of(1, 12, 13, 14, 15, 16)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(1);

        assertThat(
                LottoTicket.createFromIntegerList(List.of(1, 2, 3, 14, 15, 16)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(3);

        assertThat(
                LottoTicket.createFromIntegerList(List.of(6, 5, 4, 3, 2, 1)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(6);
    }
}
