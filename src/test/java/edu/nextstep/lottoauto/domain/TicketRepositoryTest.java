package edu.nextstep.lottoauto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TicketRepositoryTest {

    @Test
    @DisplayName("Ticket 저장 및 조회 Test")
    void saveAndFindAll() {
        // given
        Ticket ticket = Ticket.madeBy(() -> createNumbersFromTo(1, 6));

        // when
        TicketRepository ticketRepository = new TicketRepository();
        ticketRepository.save(ticket);

        // then
        assertThat(ticketRepository.findAll().get(0)).isEqualTo(ticket);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
