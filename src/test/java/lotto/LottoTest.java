package lotto;

import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    private final Lottos lottos = new Lottos();

    @Test
    public void 로또_저장() {
        lottos.saveLotto(1, List.of(15, 23, 13, 44, 5, 34));

        assertThat(lottos.provideLottosInfo().get(1)).isEqualTo(List.of(15, 23, 13, 44, 5, 34));
    }
}
