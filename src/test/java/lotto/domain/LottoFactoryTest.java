package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @Test
    @DisplayName("로또구매/돈을내면/돈만큼 로또들을 준다")
    void buyLottos() {
        Money money = new Money(2000);
        MyLottos myLottos = LottoFactory.buy(money);

        assertThat(myLottos.getLottos()).hasSize(2);
    }
}