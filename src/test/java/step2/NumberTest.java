package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    void create() {
        Number number = new Number(1);
        assertThat(number).isEqualTo(new Number(1));
    }

    @Test
    void random() {
        Number random = Number.random();
        assertThat(random.getNumber()).isGreaterThanOrEqualTo(1);
        assertThat(random.getNumber()).isLessThanOrEqualTo(45);
    }


}
