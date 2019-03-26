package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottoGeneratorTest {
    @Test
    public void 번호목록이_없으면_랜덤으로_로또를_생성한다() {
        LottoGenerator lottoGenerator = new DefaultLottoGenerator(new LottoMoney(15000));
        List<Lotto> lottos = lottoGenerator.generate();
        assertThat(lottos).hasSize(15);
    }

    @Test
    public void 번호목록을_가지고_있으면_포함해서_생성한다() {
        LottoGenerator lottoGenerator = new DefaultLottoGenerator(
            new LottoMoney(15000),
            Arrays.asList(new Integer[]{1,2,3,4,5,6}, new Integer[]{7,8,9,10,11,12})
        );

        List<Lotto> lottos = lottoGenerator.generate();
        assertThat(lottos).contains(Lotto.create(1,2,3,4,5,6));
        assertThat(lottos).contains(Lotto.create(7,8,9,10,11,12));
    }
}
