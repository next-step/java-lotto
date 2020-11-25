package my.project.lotto.domain;

import my.project.constants.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-23 오후 2:06
 * Developer : Seo
 */
class MachineTest {
    private Machine machine;

    @BeforeEach
    void setUp() {
        this.machine = new Machine();
    }

    @DisplayName("인스턴스 확인")
    @Test
    void init() {
        assertThat(machine.pop()).isInstanceOf(Integer.class);
    }

    @DisplayName("1~45 사이 숫자가 나와야 한다")
    @Test
    void whenPop_shouldBeBetween() {
        assertThat(machine.pop()).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER);
    }

    @DisplayName("이전 숫자는 제외된다")
    @Test
    void whenPop_shouldNotBePrevious() {
        int num = machine.pop();
        assertThat(num).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER);
        assertThat(machine.pop()).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER)
                                .isNotEqualTo(num);
    }

    @DisplayName("6개의 숫자는 모두 다르다")
    @Test
    void whenPop_shouldBeAllDifferent() {
        int num1 = machine.pop();
        int num2 = machine.pop();
        int num3 = machine.pop();
        int num4 = machine.pop();
        int num5 = machine.pop();
        int num6 = machine.pop();

        assertThat(num1).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER)
                        .isNotEqualTo(num2)
                        .isNotEqualTo(num3)
                        .isNotEqualTo(num4)
                        .isNotEqualTo(num5)
                        .isNotEqualTo(num6);

        assertThat(num2).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER)
                        .isNotEqualTo(num3)
                        .isNotEqualTo(num4)
                        .isNotEqualTo(num5)
                        .isNotEqualTo(num6);

        assertThat(num3).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER)
                        .isNotEqualTo(num4)
                        .isNotEqualTo(num5)
                        .isNotEqualTo(num6);

        assertThat(num4).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER)
                        .isNotEqualTo(num5)
                        .isNotEqualTo(num6);

        assertThat(num5).isBetween(Rule.MIN_NUMBER, Rule.MAX_NUMBER)
                        .isNotEqualTo(num6);
    }

}
