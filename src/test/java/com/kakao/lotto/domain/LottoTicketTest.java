package com.kakao.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    @DisplayName("숫자 6개로 로또 티켓 한장을 발급할 수 있다.")
    void of() {
        assertThat(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @Test
    @DisplayName("숫자 6개로 로또 티켓 한장은 정렬되어 발급된다.")
    void ofSorted() {
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(3, 4, 6, 5, 1, 2));
        assertThat(lottoTicket.getLottoNumbers()).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }

    @Test
    @DisplayName("티켓 한장을 발급할 때 숫자가 6개가 아니면 에러")
    void ofFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("티켓 한장을 발급 할 때 6개 숫자를 입력하지만 중복되는 숫자가 있는 경우 에러")
    void ofFailDuplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }

}
