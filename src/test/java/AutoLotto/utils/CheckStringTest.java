package AutoLotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckStringTest {

    @Test
    void checkMoneyIsNullOrBlank() {
        assertThat(CheckString.isNullOrBlank(" ")).isEqualTo(true);
        assertThat(CheckString.isNullOrBlank("")).isEqualTo(true);
        assertThat(CheckString.isNullOrBlank("   100")).isEqualTo(false);
    }
}
