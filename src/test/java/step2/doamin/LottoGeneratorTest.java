package step2.doamin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoGenerator;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    private static Lotto generate(int count) {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @BeforeEach
    void before() {
        lottoGenerator.setGenerableStrategy(LottoGeneratorTest::generate);
    }

    @Test
    public void generateLottosWithRandom() {
        //given
        int lottoCount = 5;
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lottoResult = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGenerator.setGenerableStrategy(count -> lottoResult);

        //when
        List<Lotto> lottos = lottoGenerator.generateLottos(lottoCount);

        //then
        assertThat(lottos).hasSize(lottoCount);
        assertThat(lottos).containsOnly(lottoResult);
    }
}