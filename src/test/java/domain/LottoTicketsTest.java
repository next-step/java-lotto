package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("수동 내역 리스트와 자동 내역 리스트 합쳐서 출력 한다.")
    @Test
    void concatTicketTest() {
        //given
        LottoTicket manual1 = generateFixedLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket manual2 = generateFixedLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoTicket manual3 = generateFixedLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8));
        LottoTicket auto1 = generateFixedLottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16));
        LottoTicket auto2 = generateFixedLottoTicket(Arrays.asList(21, 22, 23, 24, 25, 26));
        LottoTickets manualLottoTickets = new LottoTickets(Arrays.asList(manual1, manual2, manual3));
        LottoTickets autoLottoTickets = new LottoTickets(Arrays.asList(auto1, auto2));

        // when
        LottoTickets concatTickets = manualLottoTickets.concat(autoLottoTickets);

        // then
        assertThat(concatTickets.lottoTicketCount()).isEqualTo(5);
    }

    private LottoTicket generateFixedLottoTicket(List<Integer> fixNumbers) {
        List<LottoNumber> lottoNumbers = fixNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }

}