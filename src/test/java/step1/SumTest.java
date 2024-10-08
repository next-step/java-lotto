package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumTest {

    @Test
    void create_test() {
        Sum sum1 = new Sum();
        assertThat(sum1).isEqualTo(new Sum());

        Sum sum2 = new Sum(10);
        assertThat(sum2).isEqualTo(new Sum(10));
    }
}
