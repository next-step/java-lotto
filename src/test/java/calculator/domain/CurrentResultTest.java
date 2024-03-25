package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CurrentResultTest {
    @Test
    @DisplayName("CurrentResult 초기화 테스트")
    public void testCurrentResultInitialization() {
        CurrentResult currentResult = new CurrentResult(3);

        assertEquals(currentResult.getCurrentResult(), 3);
    }

    @Test
    @DisplayName("CurrentResult 업데이트 테스트")
    public void testCurrentResultUpdate() {
        CurrentResult currentResult = new CurrentResult(0);

        currentResult.updateResult(3);
        assertEquals(currentResult.getCurrentResult(), 3);
    }
}