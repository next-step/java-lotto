package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.InputNumberRule;

import static org.assertj.core.api.Assertions.assertThat;

public class InputRandomRuleTest {

    @Test
    @DisplayName("입력한 수 만큼 list가 만들어지는지 테스트")
    void makeNumber() {
        assertThat(new InputNumberRule("7, 8, 9, 10, 11, 13").makeNumbers().size()).isEqualTo(6);
    }
}
