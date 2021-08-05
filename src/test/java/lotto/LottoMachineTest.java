package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    private static final int LOTTO_MONEY = 14_000;
    private static final int WRONG_LOTTO_MONEY = 14_100;

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(LOTTO_MONEY);
    }

    @Test
    @DisplayName("입력받은 금액 만큼 로또를 생성한다.")
    void createLotto() {
        assertThat(lottoMachine.lottiesCount()).isEqualTo(LOTTO_MONEY / 1000);
    }

    @Test
    @DisplayName("입력받은 금액이 잘못되었다면 예외가 발생한다.")
    void invalidAmount() {
        assertThatThrownBy(() -> new LottoMachine(WRONG_LOTTO_MONEY))
                .isInstanceOf(RuntimeException.class);
    }

}
