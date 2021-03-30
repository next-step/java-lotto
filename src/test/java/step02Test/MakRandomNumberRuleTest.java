package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.MakeRandomNumberRule;

import static org.assertj.core.api.Assertions.assertThat;

public class MakRandomNumberRuleTest {

    @Test
    @DisplayName("6개의 숫자를 만들어내는지 테스트")
    void makeNumbersTest() {
        MakeRandomNumberRule makeRandomNumberRule = new MakeRandomNumberRule();
        assertThat(makeRandomNumberRule.makeNumbers().size()).isEqualTo(6);
    }
}
