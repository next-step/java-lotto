package lotto.utils;

import lotto.domain.Money;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class AutomaticallyLottosGeneratorTest {

    @Test
    public void 금액이_만원을_가지고_있는_상태에서_수동으로_0장을_구매한_다음에_나머지를_자동으로_구매() {
        final LottosGenerator lottosGenerator = new AutomaticallyLottosGenerator();
        assertThat(lottosGenerator.generate(new Money(10000, 1000, 0))).hasSize(10);
    }


    @Test
    public void 금액이_만원을_가지고_있는_상태에서_수동으로_5장을_구매한_다음에_나머지를_자동으로_구매() {
        final LottosGenerator lottosGenerator = new AutomaticallyLottosGenerator();
        assertThat(lottosGenerator.generate(new Money(10000, 1000, 5))).hasSize(5);
    }

    @Test
    public void 금액이_만원을_가지고_있는_상태에서_전부_수동으로_구매하고_자동구매를_실행() {
        final LottosGenerator lottosGenerator = new AutomaticallyLottosGenerator();
        assertThat(lottosGenerator.generate(new Money(10000, 1000, 10))).hasSize(0);
    }

}