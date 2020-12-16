package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void 생성_테스트() {
        assertThat(Money.of(1000)).isEqualTo(Money.of(1000));
    }

}
