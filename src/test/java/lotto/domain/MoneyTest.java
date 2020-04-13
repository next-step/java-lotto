package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    private Money money;

    @BeforeEach
    public void setup() {
        money = new Money(14000);
    }

    @Test
    public void create() {
        assertThat(money).isEqualTo(new Money(14000));
    }

    @Test
    public void insufficientInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            money = new Money(999);
        });
    }

    @Test
    public void getEarningRate() {
        int totalWinningMoney = 5000;
        assertThat(money.getEarningRate(totalWinningMoney)).isEqualTo(new BigDecimal("0.35"));
    }
}
