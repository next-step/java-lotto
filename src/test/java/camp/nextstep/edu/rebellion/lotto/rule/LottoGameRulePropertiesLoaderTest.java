package camp.nextstep.edu.rebellion.lotto.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameRulePropertiesLoaderTest {
    @DisplayName("로또 게임 룰 설정 파일을 제대로 읽어오는 지 확인")
    @Test
    public void loadTest() {
        // when & then
        assertDoesNotThrow(
                () -> LottoGameRulePropertiesLoader.load());
    }
}
