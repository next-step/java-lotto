package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.exception.isNotEnoughMoneyException;
import secondplacelotto.model.Money;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {

    @Test
    @DisplayName("구매 가능한 로또를 제대로 가져오는가")
    public void computeBuyableLotto() {

        assertThrows(isNotEnoughMoneyException.class, () ->
                new Money(500));
    }
}
