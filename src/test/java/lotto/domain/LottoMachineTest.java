package lotto.domain;

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
                        LottoTicket.of(Arrays.asList(
                                LottoNumber.valueOf(1),
                                LottoNumber.valueOf(2),
                                LottoNumber.valueOf(3),
                                LottoNumber.valueOf(4),
                                LottoNumber.valueOf(5),
                                LottoNumber.valueOf(6))
                        ),
                        LottoTicket.of(Arrays.asList(
                                LottoNumber.valueOf(2),
                                LottoNumber.valueOf(3),
                                LottoNumber.valueOf(4),
                                LottoNumber.valueOf(5),
                                LottoNumber.valueOf(6),
                                LottoNumber.valueOf(7))
                        ),
                        LottoTicket.of(Arrays.asList(
                                LottoNumber.valueOf(3),
                                LottoNumber.valueOf(4),
                                LottoNumber.valueOf(5),
                                LottoNumber.valueOf(6),
                                LottoNumber.valueOf(7),
                                LottoNumber.valueOf(8))
                        )
                ));
            }

            @Override
            public LottoTicket manual(final String numbers) {
                return LottoTicket.of(Arrays.asList(
                        LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6))
                );
            }

            @Override
            public WinningLotto winning(final String winningNumbers, final String bonusNumber) {
                LottoTicket winningTicket = LottoTicket.of(Arrays.asList(
                        LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6))
                );
                return WinningLotto.of(winningTicket, LottoNumber.valueOf(7));
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
        LottoTicket lottoTicket = lottoMachine.manual("1, 2, 3, 4, 5, 6");

        // then
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("당첨 로또를 생성할 수 있다.")
    @Test
    void winning() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        // when
        WinningLotto winningLotto = lottoMachine.winning(winningNumbers, bonusNumber);

        // then
        assertThat(winningLotto).isNotNull();
    }
}
