package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {
    private List<List<LottoNumber>> ascendingLottoTickets;
    private List<LottoNumber> ascendingLottoNumbers;
    
    @BeforeEach
    void setUp() {
        ascendingLottoNumbers = IntStream.rangeClosed(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        ascendingLottoTickets = IntStream.range(0, 2)
                .mapToObj(ticketCount -> ascendingLottoNumbers)
                .collect(Collectors.toList());
    }
    
    @Test
    @DisplayName("여러장의 로또 생성")
    void create() {
        LottoTickets lottoTickets = new LottoTickets(ascendingLottoTickets);
        assertThat(lottoTickets).isEqualTo(new LottoTickets(ascendingLottoTickets));
    }
}