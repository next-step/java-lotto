package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.LottoNoGenerator.generate;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoSetTest {

    private List<Lotto> lottos;

    @Before
    public void setup() {
        lottos = Arrays.asList(
                Lotto.create(generate(1, 10, 15, 20, 25, 30)),
                Lotto.create(generate(10, 15, 20, 25, 30, 35)),
                Lotto.create(generate(20, 25, 30, 35, 40, 45))
        );
    }

    @Test
    public void 로또목록으로_로또셋을_생성할수있다() {
        LottoSet lottoSet = LottoSet.create(lottos);
        assertThat(lottoSet).isNotNull();
        assertThat(lottoSet.sizeOfAutomatic()).isEqualTo(3);
    }

    @Test
    public void 일치하는_로또셋_갯수를_알수있다() {
        LottoSet lottoSet = LottoSet.create(lottos);

        assertThat(lottoSet.numberOfMatches(generate(1, 10, 15, 16, 17, 18), 3)).isEqualTo(1);
        assertThat(lottoSet.numberOfMatches(generate(20, 25, 30, 31, 32, 33), 3)).isEqualTo(3);
    }
}