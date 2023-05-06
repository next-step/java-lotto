package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberStrategyRandomTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberStrategySequentialTest.class);
    int lowLimit = 7;
    int highLimit = 45;

    @DisplayName("입력한 범위 사이의 값만 출력되는지를 검증한다")
    @RepeatedTest(1000)
    public void validateRange() {
        int generatedNumber = NumberStrategyRandom.of().generate(lowLimit, highLimit);
        LOGGER.info(() -> String.format("생성된 숫자는 %d 입니다", generatedNumber));
        assertThat(generatedNumber).isBetween(lowLimit, highLimit);
    }
}