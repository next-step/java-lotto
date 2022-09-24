package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private List<LottoNumber> ascendingLottoNumbers;
    
    @BeforeEach
    void setUp() {
        ascendingLottoNumbers = IntStream.rangeClosed(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
    
    @Test
    @DisplayName("로또 티켓 한 장 생성")
    void create() {
        LottoTicket lottoTicket = new LottoTicket(ascendingLottoNumbers);
        assertThat(lottoTicket).isEqualTo(new LottoTicket(ascendingLottoNumbers));
    }
}