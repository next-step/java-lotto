package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.LottoNumberGenerator.generate;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoSetTest {

    private List<Lotto> lottos;

    @Before
    public void setup() {
        lottos = Arrays.asList(
                Lotto.create(generate(1, 10, 15, 20, 25, 30)),
                Lotto.create(generate(20, 25, 30, 35, 40, 45)),
                Lotto.create(generate(35, 40, 45, 50, 55, 60))
        );
    }

    @Test
    public void 로또셋을_갯수만큼_생성할수있다() {
        LottoSet lottoSet = LottoSet.create(10);
        assertThat(lottoSet).isNotNull();
        assertThat(lottoSet.size()).isEqualTo(10);
    }

    @Test
    public void 로또목록으로_로또셋을_생성할수있다() {
        LottoSet lottoSet = LottoSet.create(lottos);
        assertThat(lottoSet).isNotNull();
        assertThat(lottoSet.size()).isEqualTo(3);
    }

    @Test
    public void 일치하는_로또셋_갯수를_알수있다() {
        LottoSet lottoSet = LottoSet.create(lottos);

        assertThat(lottoSet.numberOfMatches(generate(1, 10, 15, 91, 92, 93), 3)).isEqualTo(1);
        assertThat(lottoSet.numberOfMatches(generate(20, 25, 30, 91, 92, 93), 3)).isEqualTo(2);
    }
}