package vo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;


public class LottosTest {
    @Test
    public void generateByMoney() {
        //Give
        Lottos lottos = LottoGenerator.generateByMoney(new Money(5_000));

        //When
        //Then
        System.out.println(lottos);
        assertThat(lottos.count()).isEqualTo(5);
    }
}