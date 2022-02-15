package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {


    @Test
    @DisplayName("자동 로또를 개수에 맞게 구매했는지 테스트")
    void auto() {
        LottoTickets autoTickets = LottoTickets.auto(3);
        assertThat(autoTickets.getLottos().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("수동 로또를 개수에 맞게 구매했는지 테스트")
    void manual() {
        Lotto lotto1 = Lotto.create(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        Lotto lotto2 = Lotto.create(Stream.of(5, 6, 7, 8, 9, 10)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        List<Lotto> lottoTickets = Stream.of(lotto1, lotto2)
                .collect(Collectors.toList());

        LottoTickets manualTickets = LottoTickets.manual(lottoTickets);
        assertThat(manualTickets.getLottos().size()).isEqualTo(2);
    }

}