package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.model.numberRule.RandomNumberRule;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberRuleTest {

    @Test
    @DisplayName("랜덤한 숫자 6개 출력 테스트")
    void makeRandomNumber() {
        RandomNumberRule randomNumberRule = new RandomNumberRule();
        assertThat(randomNumberRule.makeNumbers().size()).isEqualTo(6);
    }
}
