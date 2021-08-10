package lotto;

import lotto.domain.Lotties;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.exception.InvalidLottoPurchaseAmountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private static final int LOTTO_MONEY = 14_000;
    private static final int WRONG_LOTTO_MONEY = 14_100;

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("입력받은 금액 만큼 로또를 생성한다.")
    void createLotto() {
        Lotties randomLotties = lottoMachine.createRandomLotties(new Money(LOTTO_MONEY));
        Assertions.assertThat(randomLotties.size()).isEqualTo(LOTTO_MONEY / 1000);
    }

    @Test
    @DisplayName("입력받은 금액이 잘못되었다면 예외가 발생한다.")
    void invalidAmount() {
        assertThatThrownBy(() -> lottoMachine.createRandomLotties(new Money(WRONG_LOTTO_MONEY)))
                .isInstanceOf(InvalidLottoPurchaseAmountException.class);
    }
}