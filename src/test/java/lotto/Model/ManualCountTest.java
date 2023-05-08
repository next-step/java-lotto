package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualCountTest {
    @Test
    @DisplayName("구매한 ticket 개수보다 더 많이 수동구매하면 return error")
    public void manualCount_above_countOfTicket() {
        int countOfTicket = 3;
        String inputNumber = "4";

        assertThatThrownBy(() -> new ManualCount(inputNumber, countOfTicket))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 ticket 개수보다 같게 수동구매하면 return normal")
    public void manualCount_eqal_countOfTicket() {
        int countOfTicket = 3;
        String inputNumber = "3";

        int expected = 3;
        int actual = new ManualCount(inputNumber, countOfTicket).value();

        assertThat(actual).isEqualTo(expected);
    }

}