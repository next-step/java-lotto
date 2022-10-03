package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketMachineTest {

    @Test
    @DisplayName("숫자 생성 객체를 받았을 때 정상적으로 티켓을 생성한다.")
    void createTicket() {
        LottoTicket lottoTicket = new TicketMachine().createLottoTicket(() -> createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::new)
            .collect(toList());
    }
}
