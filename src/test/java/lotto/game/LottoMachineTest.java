package lotto.game;

import lotto.exception.LottoIllegalArgumentException;
import lotto.number.LottoBalls;
import lotto.strategy.FixedLottoNumberStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("사용자가 입력한 금액이 원하는 수의 수동 로또를 살 수 없는 금액이면 예외가 발생한다.")
    @Test
    void validateManualLottoCount() {
        assertThatThrownBy(() -> lottoMachine.validateManualLottoCount(new Money(400), new LottoCount(1)))
                .isInstanceOf(LottoIllegalArgumentException.class);
    }

    @DisplayName("로또 티켓 1개를 만들 수 있다.")
    @Test
    void generateLottoTicket() {
        LottoBalls lottoBalls = lottoMachine.generateLottoTicket(new FixedLottoNumberStrategy(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoBalls).isEqualTo(new LottoBalls(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("자동 번호 로또 티켓 2개를 만들 수 있다.")
    @Test
    void generateAutoLottoTickets() {
        List<LottoBalls> lottoBalls = lottoMachine.generateAutoLottoTicket(new LottoCount(2));
        assertThat(lottoBalls).hasSize(2)
                .isEqualTo(
                        List.of(
                                new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoBalls(List.of(1, 2, 3, 4, 5, 6))
                        ));
    }

    @DisplayName("수동 번호 로또 티켓 2개를 만들 수 있다.")
    @Test
    void generateManualLottoTickets() {
        List<LottoBalls> lottoBalls = lottoMachine.generateManualLottoTicket(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoBalls).hasSize(2)
                .isEqualTo(
                        List.of(
                                new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoBalls(List.of(1, 2, 3, 4, 5, 6))
                        ));
    }

    @DisplayName("수동 번호 1개 자동 번호 1개 로또 티켓을 만들 수 있다.")
    @Test
    void generateLottoTickets() {
        List<LottoBalls> lottoBalls = lottoMachine.generateLottoTickets(List.of(List.of(1, 2, 3, 4, 5, 6)), new LottoCount(1));
        assertThat(lottoBalls).hasSize(2)
                .isEqualTo(
                        List.of(
                                new LottoBalls(List.of(1, 2, 3, 4, 5, 6)), new LottoBalls(List.of(1, 2, 3, 4, 5, 6))
                        ));
    }

}
