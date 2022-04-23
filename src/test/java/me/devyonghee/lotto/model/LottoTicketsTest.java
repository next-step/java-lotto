package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 응모권들")
class LottoTicketsTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> LottoTickets.from(Collections.singletonList(
                LottoTicket.from(LottoNumbers.from(IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::from).collect(Collectors.toList()))
                ))));
    }

    @Test
    @DisplayName("로또 응모권들은 필수")
    void instance_null_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> LottoTickets.from(null));
    }
}
