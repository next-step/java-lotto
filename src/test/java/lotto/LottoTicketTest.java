package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    @Test
    void 여섯개의_서로_다른_숫자_범위는_1부터_45() {
        assertThat(new LottoTicket(List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(LottoTicket.class);
        assertThat(new LottoTicket(List.of(1, 20, 30, 40, 45, 16))).isInstanceOf(LottoTicket.class);
    }

    @Test
    void 중복된_숫자가_포함되면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1, 1, 1, 1, 1, 1)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1, 1, 2, 3, 4, 5)));

    }

    @Test
    void 범위_벗어난_숫자_1보다_작은수_포함되면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(0, 1, 2, 3, 4, 5)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(-1, 1, 2, 3, 4, 5)));
    }

    @Test
    void 범위_벗어난_숫자_45보다_큰수_포함되면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 46)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 50)));
    }

    @Test
    void 목록에_포함된_숫자가_6개가_아니면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(new ArrayList<>()));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 공통된_숫자_갯수_반환() {
        LottoTicket winningTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

        assertThat(
                new LottoTicket(List.of(11, 12, 13, 14, 15, 16)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(0);

        assertThat(
                new LottoTicket(List.of(1, 12, 13, 14, 15, 16)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(1);

        assertThat(
                new LottoTicket(List.of(1, 2, 3, 14, 15, 16)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(3);

        assertThat(
                new LottoTicket(List.of(6, 5, 4, 3, 2, 1)).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(6);
    }
}
