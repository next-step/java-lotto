package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    void 로또를_출력() {
        LottoNumberStrategy lottoNumberStrategy = new FraudStrategy();
        Lotto lotto = Lotto.print(lottoNumberStrategy);
        Assertions.assertThat(lotto).isEqualTo(
            new Lotto(
                List.of(12, 13, 14, 15, 16)
            )
        );
    }
}
