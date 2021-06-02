package lotto.store;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetTest {

    @Test
    @DisplayName(value = "로또 가격을 입력받아 구매 가능한 예산이 아니면 IllegalArgumentException을 일으킨다")
    void purchasable() {
        Budget budget = new Budget(500);
        int price = 1_000;

        assertThrows(
            IllegalArgumentException.class,
            () -> budget.isPurchasable(price));
    }

    @Test
    @DisplayName(value = "로또를 구매하기에 충분한 예산을 입력하면 exception을 일으키지 않는다")
    void enoughBudget() {
        Budget budget = new Budget(10_000);
        int price = 1_000;

        assertDoesNotThrow(
            () -> budget.isPurchasable(price)
        );
    }

}