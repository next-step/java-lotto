package AutoLotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckMoneyTest {

    @Test
    void checkMoneyIsNullOrBlank() {
        assertThat(CheckMoney.isNullOrBlank(" ")).isEqualTo(true);
        assertThat(CheckMoney.isNullOrBlank("")).isEqualTo(true);
        assertThat(CheckMoney.isNullOrBlank("   100")).isEqualTo(false);
    }
}
