package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 기계(LottoMachine) 테스트")
public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine() {

            @Override
            public LottoTickets generate(final long amount, final List<String> manualNumbers) {
                return LottoTickets.of(Arrays.asList(
                        createLottoTicket(1, 2, 3, 4, 5, 6),
                        createLottoTicket(2, 3, 4, 5, 6, 7),
                        createLottoTicket(3, 4, 5, 6, 7, 8)
                ));
            }

            @Override
            public WinningLotto winning(final String winningNumbers, final String bonusNumber) {
                LottoTicket winningTicket = createLottoTicket(1, 2, 3, 4, 5, 6);
                return WinningLotto.of(winningTicket, LottoNumber.valueOf(7));
            }

            private LottoTicket createLottoTicket(final int... value) {
                return Arrays.stream(value)
                        .mapToObj(LottoNumber::valueOf)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::of));
            }
        };
    }

    @DisplayName("로또 티켓을 생성할 수 있다.")
    @Test
    void generate() {
        // when
        LottoTickets lottoTickets = lottoMachine.generate(10, new ArrayList<>());

        // then
        assertThat(lottoTickets).isNotNull();
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
