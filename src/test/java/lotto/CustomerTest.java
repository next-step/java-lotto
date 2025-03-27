package lotto;

import lotto.domain.Customer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CustomerTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -100, -1000})
    public void 구입금액이_0이하인경우_예외가_발생한다(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Customer().purchaseLotto(amount));
    }

}
