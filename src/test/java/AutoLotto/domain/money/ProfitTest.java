package AutoLotto.domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    @Test
    void checkPlusProfitBy() {
        assertThat(Profit.isPlusProfitBy(14000,5000)).isEqualTo(false);
        assertThat(Profit.isPlusProfitBy(14000,0)).isEqualTo(false);
        assertThat(Profit.isPlusProfitBy(1400,5000)).isEqualTo(true);
    }
}
