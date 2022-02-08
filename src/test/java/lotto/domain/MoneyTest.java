package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("돈_객체_생성시_주입받은_필드_값에_대한_예외_테스트")
    @Test
    void createMoneyTest() {
        Money money = new Money(3);
        assertThat(money.getValue()).isEqualTo(3);
    }
}