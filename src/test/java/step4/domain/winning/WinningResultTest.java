package step4.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.rank.Rank;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @DisplayName("WinningResult 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Map<Rank, Integer> inputMap = new EnumMap<Rank, Integer>(Rank.class);

        // when
        WinningResult winningResult = WinningResult.of(inputMap);

        // then
        assertThat(winningResult).isNotNull();
    }
}