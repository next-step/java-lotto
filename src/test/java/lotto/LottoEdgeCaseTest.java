package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.Lotto;
import lotto.domain.util.LottoConstant;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoEdgeCaseTest {

    @Test
    @DisplayName("로또 자릿 수는 6자리인지 확인")
    void lottoNumbersTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 3))
                .withMessage(LottoConstant.NUMBER_COUNT_EXCEPTION);
    }

    @Test
    @DisplayName("잔액을 초과한 액수는 출금 할 수 없음")
    void moneyWithdrawOverAmountTest() {
        Money money = new Money(10_000);

        boolean result = money.withdraw(400_000);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("잔액을 초과한 액수를 출금 시도 후 잔액 확인")
    void moneyWithdrawOverAmountBalanceTest() {
        Money money = new Money(10_000);

        money.withdraw(400_000);

        assertThat(money).isEqualTo(new Money(10_000));
    }
}
