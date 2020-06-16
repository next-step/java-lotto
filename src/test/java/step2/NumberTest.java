package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    void random() {
        Number random = Number.random();
        assertThat(random.getNumber()).isGreaterThanOrEqualTo(1);
        assertThat(random.getNumber()).isLessThanOrEqualTo(45);
    }

    @Test
    void win() {
        Number win = Number.win(1);
        assertThat(win.getNumber()).isEqualTo(1);
    }
}
