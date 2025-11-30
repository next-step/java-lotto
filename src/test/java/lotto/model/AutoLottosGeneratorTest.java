package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoLottosGeneratorTest {
    @Test
    @DisplayName("자동 로또 생성기는 LottoPurchasePlan 값에 따라서 로또를 생성한다.")
    void generate() {
        assertThat(new AutoLottosGenerator(new LottoPurchasePlan(new Money(1000), 1)).generate().size()).isEqualTo(0);
        assertThat(new AutoLottosGenerator(new LottoPurchasePlan(new Money(1000), 0)).generate().size()).isEqualTo(1);
    }
}