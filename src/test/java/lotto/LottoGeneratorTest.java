package lotto;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void 로또_발행_및_숫자정렬_확인() {
        LottoGenerator lottoGenerator = new LottoGenerator(6);
        List<Integer> lotto = lottoGenerator.generate();
        for (int i = 0; i < 6; i++) {
            assertThat(lotto.get(i)).isEqualTo(i+1);
        }
    }
}
