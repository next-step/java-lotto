package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    private List<LottoTicket> ascendingLottoTickets;
    private List<LottoNumber> ascendingLottoNumbers;
    
    @BeforeEach
    void setUp() {
        ascendingLottoNumbers = IntStream.rangeClosed(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        ascendingLottoTickets = IntStream.range(0, 2)
                .mapToObj(ticketCount -> new LottoTicket(ascendingLottoNumbers))
                .collect(Collectors.toList());
    }
    
    @Test
    @DisplayName("(입력 받은 값 / 1000) 장 만큼 자동으로 로또 발급하기.")
    void autoIssueLotto() {
        LottoTickets actualLottoTickets = LottoMachine.autoIssueLottoTickets(() -> ascendingLottoTickets);
        assertThat(actualLottoTickets).isEqualTo(new LottoTickets(ascendingLottoTickets));
    }
}
