package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void generateLottos() {
        //given
        int userPrice = 5000;
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lottoResult = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGenerator.setGenerableStrategy(count -> lottoResult);

        //when
        List<Lotto> lottos = lottoGenerator.generateLottos(userPrice);

        //then
        assertThat(lottos).hasSize(userPrice/1000);
        assertThat(lottos).containsOnly(lottoResult);
    }
}