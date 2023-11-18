package lotto;

import lotto.type.WinningLevel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLevelToAmountTableTest {
    @Test
    @DisplayName("[WinningLevelToAmountTable.convert] 모든 WinningLevel 값에 대하여 상금이 매핑되어 있는지 테스트")
    public void checkAllLevelHasValue() {
        for (WinningLevel level : WinningLevel.values()) {
            assertThat(WinningLevelToAmountTable.convert(level)).isNotNull();
        }
    }
}