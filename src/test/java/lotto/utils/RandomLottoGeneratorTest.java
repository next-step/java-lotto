package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RandomLottoGeneratorTest {

    @Test
    public void 랜덤_로또_생성() {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        BasicLotto basicLotto = randomLottoGenerator.generate();

        assertTrue(basicLotto.getTicket().toString().length() > 0);
    }
}
