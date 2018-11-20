package lotto.model;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ManualLottosGeneratorTest {

    @Test
    public void 생성_수동() {
        LottosGenerator lottosGenerator = new ManualLottosGenerator(Arrays.asList("1,2,3,4,5,6", "8,9,10,20,30,40"));
        assertThat(lottosGenerator.generate(Money.from(5000)).size()).isEqualTo(2);
    }
}