package domain.lottosGenerator;

import domain.Lotto;
import domain.Money;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ManualLottosGeneratorTest {

    private LottosGenerator generator;

    @Test
    public void 수동_로또를_반환한다() {
        generator = new ManualLottosGenerator(Collections.singletonList("1, 2, 3, 4,5,6"));
        List<Lotto> games = generator.generate(new Money(2000));

        // 돈은 2천원이지만 입력 번호는 하나이므로 한 개의 수동 로또 반환
        assertThat(games).hasSize(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동_번호_입력_잘못됬을시_Exception() {
        generator = new ManualLottosGenerator(Collections.singletonList("1, 2, 3,,5,6"));
        generator.generate(new Money(2000));
    }
}