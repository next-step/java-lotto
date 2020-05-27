package step2;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    private static List<Integer> generate(int count) {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @BeforeEach
    void before() {
        lottoGenerator.setGenerableStrategy(LottoGeneratorTest::generate);
    }
}