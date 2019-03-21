package lotto.util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 로또_발행_및_숫자정렬_확인() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lotto = lottoGenerator.generate(LottoBasicNumber.numbers);

        for (int i = 0; i < lotto.size() - 1; i++) {
            assertThat(lotto.get(i)).isLessThan(lotto.get(i + 1));
        }
    }
}
