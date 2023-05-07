package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketMachineTest {

    @Test
    void 생성자를_검증한다() {
        // given

        // when

        // then
        assertDoesNotThrow(() -> {
            new LottoTicketMachine(3, 14000);
        });
    }

    @ParameterizedTest(name = "[{index}] 수동개수: {0}, 구입금액 {1}")
    @CsvSource(value = {"5:5000", "0:5000", "3:5000"}, delimiter = ':')
    void 로또번호를_생성한다(int count, int amount) {
        // given
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(count, amount);
        List<List<Integer>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        tickets.add(Arrays.asList(1, 2, 3, 10, 11, 12));
        tickets.add(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when

        // then
        assertDoesNotThrow(() -> {
            lottoTicketMachine.createLottoTickets(tickets);
        });
    }
}
