package lotto.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoLottosGeneratorTest {

    @Test
    public void 생성_자동() {
        LottosGenerator lottosGenerator = new AutoLottosGenerator();
        assertThat(lottosGenerator.generate(Money.from(5000)).size()).isEqualTo(5);
    }
}