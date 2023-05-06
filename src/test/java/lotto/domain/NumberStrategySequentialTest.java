package lotto.domain;

import lotto.exception.NumberLimitRangeRuleViolateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberStrategySequentialTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberStrategySequentialTest.class);
    private final int lowLimit = 7;
    private final int highLimit = 45;
    private NumberStrategy numberStrategy;

    @BeforeEach
    public void beforeEach() {
        numberStrategy = NumberStrategySequential.of();
    }

    @DisplayName("입력한 범위 사이의 값만 출력되는지를 검증한다")
    @RepeatedTest(1000)
    public void validateRange() {
        //given
        //when
        int generatedNumber = numberStrategy.generate(lowLimit, highLimit);
        //then
        LOGGER.info(() -> String.format("생성된 숫자는 %d 입니다", generatedNumber));
        assertThat(generatedNumber).isBetween(lowLimit, highLimit);
    }

    @DisplayName("highLimit 가 lowLimit 보다 작은경우 예외가 발생한다")
    @Test
    public void exception() {
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            numberStrategy.generate(highLimit, lowLimit);
        }).isInstanceOf(NumberLimitRangeRuleViolateException.class)
                .hasMessageContaining("LimitRange 가 잘못 입력되었습니다");
    }
}