package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void 객체생성_테스트(){
        LottoTicket actual = new LottoTicket(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2)));
        assertThat(actual.contains(LottoNumber.of(1))).isTrue();
        assertThat(actual.contains(LottoNumber.of(2))).isTrue();
        assertThat(actual.contains(LottoNumber.of(3))).isFalse();
    }

}