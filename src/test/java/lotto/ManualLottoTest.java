package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(
                new ArrayList<>(),
                new LottoNumberGenerator()
        );
    }

    @Test
    void 수동로또구매() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        lottos.buyLotto(lotto);

        assertThat(lottos.quantity()).isEqualTo(1);

    }
}
