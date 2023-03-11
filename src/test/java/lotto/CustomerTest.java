package lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import calculator.Calculator;
import calculator.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomerTest {

    @DisplayName("정상 로또 구입 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 14000, 2000})
    void customerBudgetTest(int budget) {
        Customer customer = new Customer();

        customer.purchase(budget);

        assertThat(customer.getWallet().getLottos().size()).isEqualTo(budget / 1000);
    }

    @DisplayName("정상 로또 구입 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -200, -100000000})
    void customerBudgetExceptionTest(int budget) {
        Customer customer = new Customer();

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                customer.purchase(budget);
            }).withMessageContaining("로또를 구입할 금액이 부족합니다.");
    }
}
