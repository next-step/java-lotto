package vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    public void generateByMoney() {
        Lottos lottos = LottoGenerator.generateByMoney(new Money(5000));
        System.out.println(lottos);
        assertThat(lottos.count()).isEqualTo(5);
    }
}