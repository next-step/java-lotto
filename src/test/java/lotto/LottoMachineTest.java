package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 기계(LottoMachine) 테스트")
public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine() {
            @Override
            public LottoTickets automatic(final long amount) {
                return LottoTickets.of(Arrays.asList(
                        LottoTicket.of(1, 2, 3, 4, 5, 6),
                        LottoTicket.of(2, 3, 4, 5, 6, 7),
                        LottoTicket.of(3, 4, 5, 6, 7, 8)));
            }

            @Override
            public LottoTicket manual(final String numbers) {
                return LottoTicket.of(1, 2, 3, 4, 5, 6);
            }
        };
    }

    @DisplayName("자동 로또 티켓을 생성할 수 있다.")
    @Test
    void automatic() {
        // when
        LottoTickets lottoTickets = lottoMachine.automatic(10);

        // then
        assertThat(lottoTickets).isNotNull();
    }

    @DisplayName("수동 로또 티켓을 생성할 수 있다.")
    @Test
    void manual() {
        // when
        LottoTicket lottoTicket = lottoMachine.manual("1,2,3,4,5,6");

        // then
        assertThat(lottoTicket).isNotNull();
    }
}
