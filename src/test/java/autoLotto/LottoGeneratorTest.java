package autoLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("로또 번호는 6개의 숫자로 이루어지고, 요청할 때마다 다른 로또 번호를 생성한다.")
    @Test
    void generate() {
        Set<Integer> firstLotto = lottoGenerator.generate();
        Set<Integer> secondLotto = lottoGenerator.generate();
        assertEquals(6, firstLotto.size());
        assertEquals(6, secondLotto.size());
        assertNotEquals(firstLotto, secondLotto);
        assertTrue(firstLotto.stream().allMatch(num -> num >= 1 && num <= 45));
    }
}
