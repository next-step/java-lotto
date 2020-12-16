package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    public void 생성() {
        Num num1 = Num.of(1);
        Num num2 = Num.of(2);
        Numbers numbers = new Numbers(num1, num2);
        assertThat(numbers).isEqualTo(new Numbers(Num.of(1), Num.of(2)));
    }

}
