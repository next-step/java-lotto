package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTests {
    @DisplayName("정적 팩터리 메서드로 로또 티켓을 만들 수 있다.")
    @Test
    void factoryCreateTest() {
        LottoTicket lottoTicket = LottoGenerator.create();
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("임의의 수로 중복 없는 로또 티켓을 발급해야 한다")
    @Test
    void randomTicketTest() {
        // 너무 구현 테스트가 아닌지 고민해볼 것
        Collections.shuffle(LottoGenerator.lottoSeed, new Random(10));

        LottoTicket ticketByGenerator = LottoGenerator.create();
        LottoTicket ticketByTestCode = LottoTicket.create(LottoGenerator.lottoSeed.subList(0, 6));

        assertThat(ticketByGenerator).isEqualTo(ticketByTestCode);
    }

    @DisplayName("숫자 여섯개를 입력 받아서 로또 티켓을 발급 할 수 있어야 한다.")
    @Test
    void manualTicketTest() {
        LottoTicket lottoTicket = LottoGenerator.createManualByIntList(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.size()).isEqualTo(6);
    }
}
