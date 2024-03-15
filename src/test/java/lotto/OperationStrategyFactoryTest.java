package lotto;

import lotto.domain.AddStrategy;
import lotto.domain.DivideStrategy;
import lotto.domain.MultiplyStrategy;
import lotto.domain.SubtractStrategy;
import lotto.util.OperationStrategyFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationStrategyFactoryTest {

    @Test
    @DisplayName("[성공] 연산자 문자열을 받으면 해당되는 연산 전략 인스턴스를 리턴한다.")
    void 연산_전략() {
        assertThat(OperationStrategyFactory.getStrategy("+")).isInstanceOf(AddStrategy.class);
        assertThat(OperationStrategyFactory.getStrategy("-")).isInstanceOf(SubtractStrategy.class);
        assertThat(OperationStrategyFactory.getStrategy("*")).isInstanceOf(MultiplyStrategy.class);
        assertThat(OperationStrategyFactory.getStrategy("/")).isInstanceOf(DivideStrategy.class);
    }

}
