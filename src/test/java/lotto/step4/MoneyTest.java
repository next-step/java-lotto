package lotto.step4;

import lotto.step4.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {900,990,500,100,0,-5})
    @DisplayName("로또를 구입할 최소의 돈을 갖고 있는지 검증")
    void payMoney(int money){
        Assertions.assertThatThrownBy(()->new Money(money)).isInstanceOf(IllegalArgumentException.class);
    }
}
