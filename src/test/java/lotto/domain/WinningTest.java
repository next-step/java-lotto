package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinNumberTest {
    @Test
    void create() {
        Win winNumbers = new WinNumber(1);
        assertThat(winNumber).isEqualTo(new WinNumber(1));
    }
}
