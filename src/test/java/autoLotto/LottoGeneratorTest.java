package autoLotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void generate() {
        List<Integer> firstLotto = lottoGenerator.generate();
        List<Integer> secondLotto = lottoGenerator.generate();
        assertEquals(6, firstLotto.size());
        assertEquals(6, secondLotto.size());
        assertNotEquals(firstLotto, secondLotto);
        assertTrue(firstLotto.stream().allMatch(num -> num >= 1 && num <= 45));
    }

    @Test
    void generateLottos() {
        int TEST_COUNT = 5;
        List<List<Integer>> lottos = lottoGenerator.generateLottos(TEST_COUNT);
        assertEquals(TEST_COUNT, lottos.size());
    }


}
