package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class RandomGenerableStrategyTest {

    @Test
    public void makeSequentialNumbersTest() {
        //given&when
        List<Integer> sequentialNumbers = ReflectionTestUtils
            .invokeMethod(new RandomGenerableStrategy(),
                "makeSequentialNumbers",
                LottoGenerator.LOTTO_FIRST_NUMBER,
                LottoGenerator.LOTTO_LAST_NUMBER);

        //then
        assertThat(sequentialNumbers).startsWith(LottoGenerator.LOTTO_FIRST_NUMBER);
        assertThat(sequentialNumbers).endsWith(LottoGenerator.LOTTO_LAST_NUMBER);
    }

}