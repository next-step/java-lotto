package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    public void 생성_테스트() {
        Num num =  Num.of(1);
        assertThat(num).isEqualTo(Num.of(1));
    }
}
