package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BudgetTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {1000, 2000, 1000000})
    public void create(int budget) {
        assertThat(Budget.of(budget)).isEqualTo(Budget.of(budget));
        assertThat(Budget.of(budget).budget()).isEqualTo(budget);
    }

    @ParameterizedTest(name = "create failed by not enough money: {arguments}")
    @ValueSource(ints = {-1000, 0, 999})
    public void createFailedByNotEnoughMoney(int budget) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Budget.of(budget))
                .withMessageContaining("budget must be at least 1000");
    }

    @ParameterizedTest(name = "create failed change exist: {arguments}")
    @ValueSource(ints = {1999, 1001})
    public void createFailedByChaneExist(int budget) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Budget.of(budget))
                .withMessageContaining("budget must be multiple of 1000");
    }

    @ParameterizedTest(name = "available amount: {arguments}")
    @ValueSource(ints = {1000, 2000, 1000000})
    public void availableAmount(int budget) {
        assertThat(Budget.of(budget).availableAmount()).isEqualTo(budget / Budget.GAME_PRICE);
    }
}
