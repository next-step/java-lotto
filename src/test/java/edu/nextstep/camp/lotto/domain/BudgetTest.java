package edu.nextstep.camp.lotto.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BudgetTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {0, 1000, 2000, 1000000})
    public void create(int budget) {
        assertThat(Budget.of(budget)).isEqualTo(Budget.of(budget));
        assertThat(Budget.of(budget).budget()).isEqualTo(budget);
    }

    @Test
    public void noMoney() {
        assertThat(Budget.noMoney().exhausted()).isTrue();
        assertThat(Budget.noMoney() == Budget.of(0)).isTrue();
    }

    @ParameterizedTest(name = "create failed by not enough money: {arguments}")
    @ValueSource(ints = {-1000, -1})
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
        assertThat(budget(budget).availableAmount()).isEqualTo(budget / Budget.GAME_PRICE);
    }

    @ParameterizedTest(name = "purchase from budget(1000000): {arguments}")
    @ValueSource(ints = {1, 2})
    public void purchase(int amount) {
        int budget = 1000000;
        assertThat(budget(budget).purchased(amount)).isEqualTo(budget(budget - amount * Budget.GAME_PRICE));
    }

    static Stream<Arguments> parsePurchaseFailed() {
        return Stream.of(
                Arguments.of(2, "not enough money"),
                Arguments.of(-1, "amount cannot be negative")
        );
    }

    @ParameterizedTest(name = "purchaseFailed from budget(1000): {arguments}")
    @MethodSource("parsePurchaseFailed")
    public void purchaseFailed(int amount, String expectedMessage) {
        int budget = 1000;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> budget(budget).purchased(amount))
                .withMessageContaining(expectedMessage);
    }

    @ParameterizedTest(name = "exhausted: {arguments}")
    @ValueSource(ints = {1000, 2000, 1000000})
    public void exhausted(int input) {
        Budget budget = budget(input);
        assertThat(budget.exhausted()).isFalse();
        assertThat(budget.purchased(input / Budget.GAME_PRICE).exhausted()).isTrue();
    }

    @ParameterizedTest(name = "available: {arguments}")
    @ValueSource(ints = {1000, 2000, 1000000})
    public void available(int input) {
        Budget budget = budget(input);
        assertThat(budget.available(input / Budget.GAME_PRICE)).isTrue();
        assertThat(budget.available(input / Budget.GAME_PRICE - 1)).isTrue();
        assertThat(budget.available(input / Budget.GAME_PRICE + 1)).isFalse();
    }

    public static Budget budget(int budget) {
        return Budget.of(budget);
    }
}
