package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.nextstep.lotto.domain.LottoTicketFixtures.LOTTO_TICKET_123456;
import static org.assertj.core.api.Assertions.assertThat;

class StaticCreatePolicyTest {
    @DisplayName("숫자 컬렉션으로 지정된 번호의 LottoTicket을 만들 수 있다.")
    @Test
    void staticCreateTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoTicketCreatePolicy createPolicy = new StaticCreatePolicy(numbers);

        assertThat(LottoTicket.of(createPolicy)).isEqualTo(LOTTO_TICKET_123456);
    }
}
