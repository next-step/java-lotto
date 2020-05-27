package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    private static List<Integer> generate(int count) {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
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
        List<Integer> lottoResult = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoGenerator.setGenerableStrategy(count -> lottoResult);

        //when
        List<List<Integer>> lottos = lottoGenerator.generateLottos(lottoCount);

        //then
        assertThat(lottos).hasSize(lottoCount);
        assertThat(lottos).containsOnly(lottoResult);
    }
}