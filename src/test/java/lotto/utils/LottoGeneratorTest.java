package lotto.utils;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private static final String LOTTONUMBERS1 = "1, 2, 3, 4, 5, 6";
    private static final String LOTTONUMBERS2 = "4, 5, 6, 7, 8, 9";

    @Test
    @DisplayName("수동로또 용지와 총 갯수를 입력하면 갯수만큼 로또를 반환한다.")
    void 수동로또_자동로또_반환_로또검증() {
        Lotto lotto1 = new Lotto(LOTTONUMBERS1);
        Lotto lotto2 = new Lotto(LOTTONUMBERS2);

        List<Lotto> issuedLottos = LottoGenerator.generatorLottos(new String[]{LOTTONUMBERS1, LOTTONUMBERS2}, 3);
        assertThat(issuedLottos).contains(lotto1, lotto2);
    }

    @Test
    @DisplayName("수동로또 용지와 총 갯수를 입력하면 갯수만큼 로또를 반환한다.")
    void 수동로또_자동로또_반환_사이즈검증() {
        Lotto lotto1 = new Lotto(LOTTONUMBERS1);
        Lotto lotto2 = new Lotto(LOTTONUMBERS2);

        List<Lotto> issuedLottos = LottoGenerator.generatorLottos(new String[]{LOTTONUMBERS1, LOTTONUMBERS2}, 5);
        assertThat(issuedLottos).hasSize(5);
    }

    @Test
    void create_Lottos() {
        List<Lotto> lottos = LottoGenerator.generateLottos(4);
        assertThat(lottos).hasSize(4);
    }
}
