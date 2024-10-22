package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private static final String LOTTONUMBERS1 = "1, 2, 3, 4, 5, 6";
    private static final String LOTTONUMBERS2 = "4, 5, 6, 7, 8, 9";

    @Test
    void create() {
        LottoGenerator generator = new LottoGenerator(1000);
        assertThat(generator).isEqualTo(new LottoGenerator(1000));
    }

    @Test
    @DisplayName("수동로또 용지와 총 갯수를 입력하면 갯수만큼 로또를 반환한다.")
    void 수동로또_자동로또_반환_로또검증() {
        Lotto lotto1 = new Lotto(LOTTONUMBERS1);
        Lotto lotto2 = new Lotto(LOTTONUMBERS2);

        LottoGenerator generator = new LottoGenerator(3_000);
        List<Lotto> issuedLottos = generator.generatorLottos(Arrays.asList(LOTTONUMBERS1, LOTTONUMBERS2));
        assertThat(issuedLottos).contains(lotto1, lotto2);
    }

    @Test
    @DisplayName("수동로또 용지와 총 갯수를 입력하면 갯수만큼 로또를 반환한다.")
    void 수동로또_자동로또_반환_사이즈검증() {
        LottoGenerator generator = new LottoGenerator(5_000);
        List<Lotto> issuedLottos = generator.generatorLottos(Arrays.asList(LOTTONUMBERS1, LOTTONUMBERS2));
        assertThat(issuedLottos).hasSize(5);
    }
}
