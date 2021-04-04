package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.rank.Rank;

import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @DisplayName("WinningResult 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Map<Rank, Integer> rankIntegerMap = new EnumMap<>(Rank.class);

        // when
        WinningResult winningResult = WinningResult.of(rankIntegerMap);

        // then
        assertThat(winningResult).isNotNull();
    }

    @DisplayName("WinningResult 인스턴스 Null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_Null() {
        // given
        Map<Rank, Integer> rankIntegerMap = null;

        // when
        assertThatThrownBy(()->WinningResult.of(rankIntegerMap))
                .isInstanceOf(MapNullPointerException.class)
                .hasMessageContaining("Map 인스턴스가 Null 입니다.");
    }
}