package step1;

import org.junit.jupiter.api.Test;
import step1.CalculateStratety.Divide;
import step1.CalculateStratety.Minus;
import step1.CalculateStratety.Multi;
import step1.CalculateStratety.Plus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StrategiesTest {

    @Test
    void 사칙연산에_맞는_구현체() {
        Strategies strategies = new Strategies();
        assertThat(strategies.getStrategy("+")).isInstanceOf(Plus.class);
        assertThat(strategies.getStrategy("-")).isInstanceOf(Minus.class);
        assertThat(strategies.getStrategy("*")).isInstanceOf(Multi.class);
        assertThat(strategies.getStrategy("/")).isInstanceOf(Divide.class);
    }

}