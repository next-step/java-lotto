package com.java.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsGeneratorTest {

    @Test
    @DisplayName("입력한 숫자 만큼 자동으로 로또 티켓 생성")
    void automaticTicketsGenerator() {
        int count = 5;
        LottoTickets tickets = LottoTicketsGenerator.automaticTicketsGenerator(count);
        assertThat(tickets.count()).isEqualTo(count);
    }
}
