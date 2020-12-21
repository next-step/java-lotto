package com.ssabae.nextstep.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
class LottoTicketTest {

    @Test
    @DisplayName("LottoTicket 생성시 에러 Test")
    void shouldBeExceptionWhenGenerateLottoTicketTest() {
        assertThatThrownBy(() -> new LottoTicket(
                Collections.singletonList(
                        LottoNumber.of(1))
                )).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoTicket(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(1),
                        LottoNumber.of(1),
                        LottoNumber.of(1),
                        LottoNumber.of(1),
                        LottoNumber.of(1)))
                ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoTicket(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6),
                        LottoNumber.of(7)))
                ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoTicket 생성 Test")
    void lottoTicketTest() {
        LottoTicket ticket = new LottoTicket(
                Arrays.asList(
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5),
                    LottoNumber.of(6)
                )
        );

        List<LottoNumber> numbers = ticket.getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers).containsExactly(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }
}
