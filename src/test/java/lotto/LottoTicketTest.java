package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    @Test
    void 여섯개의_서로_다른_숫자() {
        assertThat(new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList()))).isInstanceOf(LottoTicket.class);
        assertThat(new LottoTicket(Stream.of(1, 20, 30, 40, 45, 16).map(LottoNumber::new).collect(Collectors.toList()))).isInstanceOf(LottoTicket.class);
    }

    @Test
    void 중복된_숫자가_포함되면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(Stream.of(1, 1, 1, 1, 1, 1).map(LottoNumber::new).collect(Collectors.toList())));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(Stream.of(1, 1, 2, 3, 4, 5).map(LottoNumber::new).collect(Collectors.toList())));
    }

    @Test
    void 목록에_포함된_숫자가_6개가_아니면_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(new ArrayList<>()));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(Stream.of(1).map(LottoNumber::new).collect(Collectors.toList())));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(Stream.of(1, 2, 3, 4, 5).map(LottoNumber::new).collect(Collectors.toList())));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6, 7).map(LottoNumber::new).collect(Collectors.toList())));
    }

    @Test
    void 공통된_숫자_갯수_반환() {
        LottoTicket winningTicket = new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(
                new LottoTicket(Stream.of(11, 12, 13, 14, 15, 16).map(LottoNumber::new).collect(Collectors.toList())).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(0);

        assertThat(
                new LottoTicket(Stream.of(1, 12, 13, 14, 15, 16).map(LottoNumber::new).collect(Collectors.toList())).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(1);

        assertThat(
                new LottoTicket(Stream.of(1, 2, 3, 14, 15, 16).map(LottoNumber::new).collect(Collectors.toList())).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(3);

        assertThat(
                new LottoTicket(Stream.of(6, 5, 4, 3, 2, 1).map(LottoNumber::new).collect(Collectors.toList())).getTheNumberOfCommonNumbers(winningTicket)
        ).isEqualTo(6);
    }
}
