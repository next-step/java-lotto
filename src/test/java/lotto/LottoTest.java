package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {

    @Test
    void 로또를_출력() {
        LottoNumberStrategy lottoNumberStrategy = () -> new ArrayList<>(List.of(16, 15, 14, 13, 12));
        Lotto lotto = Lotto.print(lottoNumberStrategy);
        Assertions.assertThat(lotto).isEqualTo(
            new Lotto(
                new ArrayList<>(List.of(12, 13, 14, 15, 16))
            )
        );
    }
}
