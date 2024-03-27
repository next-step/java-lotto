package lottery.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinPrizeTypeTest {

    @Test
    @DisplayName("당첨 개수에 따른 타입 조회 테스트")
    void fromMatchCountTest() {
        // Given
        final Long matchCount = 3L;

        // When
        WinPrizeType actual = WinPrizeType.fromMatchCount(matchCount);

        // Then
        assertThat(actual).isEqualTo(WinPrizeType.THREE_MATCH);
    }
}
